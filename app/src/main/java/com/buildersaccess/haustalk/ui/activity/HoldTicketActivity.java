package com.buildersaccess.haustalk.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.buildersaccess.haustalk.R;
import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.model.entity.Homevendor;
import com.buildersaccess.haustalk.model.entity.HomevendorDat;
import com.buildersaccess.haustalk.model.entity.Login;
import com.buildersaccess.haustalk.model.entity.Req_ba_openticketpm;
import com.buildersaccess.haustalk.presenter.TicketsPresenter;
import com.buildersaccess.haustalk.presenter.impl.HoldTicketstPresenterImpl;
import com.buildersaccess.haustalk.ui.adapter.TicketsAdapter;
import com.buildersaccess.haustalk.ui.view.ShowTicketsView;
import com.buildersaccess.haustalk.ui.widget.RefreshLayout;
import com.buildersaccess.haustalk.utility.UiTools;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HoldTicketActivity extends AppCompatActivity implements ShowTicketsView {

    @InjectView(R.id.lv_result)
    ListView lvResult;

    RefreshLayout srlMain;
    @InjectView(R.id.tv_notfound)
    TextView tvNotfound;

    private TicketsAdapter ticketsAdapter;
    private List<HomevendorDat> listHomevendorDat;
    private TicketsPresenter holdTicketsPresenter;
    private int page = 1;
    private boolean isLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_ticket);
        HaustalkApplication.getInstance().addActivity(this);
        ButterKnife.inject(this);
        HaustalkApplication.getInstance().addActivity(this);
        UiTools.setBackActionBarLayout(this, "Tickets on Hold");
        holdTicketsPresenter = new HoldTicketstPresenterImpl(this);
        this.isLoad = false;
        ticketsAdapter = new TicketsAdapter(this, null);
        lvResult.setAdapter(ticketsAdapter);
        lvResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listHomevendorDat != null) {
                    HomevendorDat homevendorDat = listHomevendorDat.get(position);
                    Intent intent = new Intent();
                    intent.putExtra("idwebcare1", homevendorDat.getIdwebcare1());
                    intent.putExtra("idcia", homevendorDat.getIdcia());
                    intent.setClass(HoldTicketActivity.this, PmticketviewActivity.class);
                    HoldTicketActivity.this.startActivity(intent);
                    overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                }
                ;
            }
        });
        srlMain = (RefreshLayout) findViewById(R.id.srl_main);
        srlMain.setAdapter(ticketsAdapter);
        srlMain.setColorScheme(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        srlMain.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isLoad = false;
                refreshView();
            }
        });
        srlMain.setOnLoadListener(new RefreshLayout.OnLoadListener() {
            @Override
            public void onLoad() {
                isLoad = true;
                refreshView();
            }
        });
        srlMain.post(new Runnable() {
            @Override
            public void run() {
                srlMain.setRefreshing(true);
            }
        });
        refreshView();
    }


    public void refreshView() {
        Login login = HaustalkApplication.getLogin();
        Req_ba_openticketpm req_ba_openticketpm = new Req_ba_openticketpm();
        req_ba_openticketpm.setToken(login.getToken());
        req_ba_openticketpm.setTokensecret(login.getTokensecret());
        if (isLoad) {
            req_ba_openticketpm.setPage(page);
            page++;
        } else {
            page = 1;
            req_ba_openticketpm.setPage(page);
        }
        this.holdTicketsPresenter.ba_holdticketpm(req_ba_openticketpm);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
        this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

    @Override
    public void showResult(Homevendor result) {
        if (isLoad && this.listHomevendorDat != null) {
            this.listHomevendorDat.addAll(result.getProjects());
        } else {
            this.listHomevendorDat = result.getProjects();
        }
        if(result.getProjects().size()==0) {
            this.tvNotfound.setVisibility(View.VISIBLE);
        }else{
            this.tvNotfound.setVisibility(View.GONE);
        }
        this.ticketsAdapter.setContent(this.listHomevendorDat);
        this.ticketsAdapter.notifyDataSetChanged();
        srlMain.setRefreshing(false);
        srlMain.setLoading(false);
    }

    @Override
    public void showError(String error) {
        srlMain.setRefreshing(false);
        srlMain.setLoading(false);
        Toast.makeText(getApplicationContext(), error,
                Toast.LENGTH_SHORT).show();
    }

}
