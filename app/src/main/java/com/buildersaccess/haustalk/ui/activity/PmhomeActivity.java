package com.buildersaccess.haustalk.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.buildersaccess.haustalk.R;
import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.model.entity.HomevendorDat;
import com.buildersaccess.haustalk.presenter.PmhomePresenter;
import com.buildersaccess.haustalk.presenter.impl.PMhomeViewPresenterImpl;
import com.buildersaccess.haustalk.ui.adapter.TicketsAdapter;
import com.buildersaccess.haustalk.ui.view.PmhomeView;
import com.buildersaccess.haustalk.utility.UiTools;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PmhomeActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, PmhomeView {
    @InjectView(R.id.lv_mytickets)
    ListView lvMytickets;
    @InjectView(R.id.ll_search_tickets)
    LinearLayout llSearchTickets;
    @InjectView(R.id.ll_open_tickets)
    LinearLayout llOpenTickets;
    @InjectView(R.id.ll_ticket_hold)
    LinearLayout llTicketHold;
    @InjectView(R.id.ll_open_surveys)
    LinearLayout llOpenSurveys;
    @InjectView(R.id.ll_logout)
    LinearLayout llLogout;
    @InjectView(R.id.srl_main)
    SwipeRefreshLayout srlMain;
    @InjectView(R.id.tv_notfound)
    TextView tvNotfound;
    @InjectView(R.id.ll_surveys_received)
    LinearLayout llSurveysReceived;

    private long exitTime = 0;
    private TicketsAdapter myTicketsAdapter;
    private List<HomevendorDat> homevendorDatList;
    private PmhomePresenter pMhomePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pmhome);
        HaustalkApplication.getInstance().addActivity(this);
        ButterKnife.inject(this);
        HaustalkApplication.getInstance().addActivity(this);
        pMhomePresenter = new PMhomeViewPresenterImpl(this);
        UiTools.setActionBarLayout(this, HaustalkApplication.getLogin().getUsername());

        myTicketsAdapter = new TicketsAdapter(this, null);
        lvMytickets.setAdapter(myTicketsAdapter);
        lvMytickets.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HomevendorDat homevendorDat = homevendorDatList.get(position);
                Intent intent = new Intent();
                intent.putExtra("idwebcare1", homevendorDat.getIdwebcare1());
                intent.putExtra("idcia", homevendorDat.getIdcia());
                intent.setClass(PmhomeActivity.this, PmticketviewActivity.class);
                PmhomeActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });
        srlMain = (SwipeRefreshLayout) findViewById(R.id.srl_main);
        srlMain.setOnRefreshListener(this);
        srlMain.setColorScheme(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        //触发刷新
        srlMain.post(new Runnable() {
            @Override
            public void run() {
                srlMain.setRefreshing(true);
            }
        });
        onRefresh();

        this.llSearchTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PmhomeActivity.this, SearchTicketsActivity.class);
                PmhomeActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });

        this.llOpenTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PmhomeActivity.this, OpenTicketActivity.class);
                PmhomeActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });

        this.llTicketHold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PmhomeActivity.this, HoldTicketActivity.class);
                PmhomeActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });

        this.llOpenSurveys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PmhomeActivity.this, OpenSurveyActivity.class);
                PmhomeActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });
        this.llSurveysReceived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PmhomeActivity.this, SurveyReceivedActivity.class);
                PmhomeActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });

        this.llLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExitDialog();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "Back again to exit.",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();

        } else {
            HaustalkApplication.getInstance().onTerminate();
            finish();
        }
    }

    @Override
    public void showMyticket(List<HomevendorDat> homevendorDatList) {
        this.homevendorDatList = homevendorDatList;
        if (homevendorDatList.size() == 0) {
            tvNotfound.setVisibility(View.VISIBLE);
        } else {
            tvNotfound.setVisibility(View.GONE);
        }

        myTicketsAdapter.setContent(homevendorDatList);
        myTicketsAdapter.notifyDataSetChanged();
        UiTools.setListViewHeightBasedOnChildren(lvMytickets);
        srlMain.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        pMhomePresenter.ba_homepm();
    }

    private void showExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Message");
        builder.setMessage("Would you want to logout ?");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent = new Intent();
                intent.setClass(PmhomeActivity.this, LoginActivity.class);
                PmhomeActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
                PmhomeActivity.this.finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        //参数都设置完成了，创建并显示出来
        builder.create().show();
    }

    @Override
    public void showError(String error) {
        srlMain.setRefreshing(false);
        Toast.makeText(getApplicationContext(), error,
                Toast.LENGTH_SHORT).show();
    }
}

