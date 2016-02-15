package com.buildersaccess.haustalk.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.buildersaccess.haustalk.R;
import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.model.entity.Homevendor;
import com.buildersaccess.haustalk.model.entity.HomevendorDat;
import com.buildersaccess.haustalk.model.entity.Login;
import com.buildersaccess.haustalk.model.entity.Req_ba_searchticketpm;
import com.buildersaccess.haustalk.presenter.SearchTicketsPresenter;
import com.buildersaccess.haustalk.presenter.impl.SearchTicketstPresenterImpl;
import com.buildersaccess.haustalk.ui.adapter.TicketsAdapter;
import com.buildersaccess.haustalk.ui.view.ShowTicketsView;
import com.buildersaccess.haustalk.utility.UiTools;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SearchTicketsActivity extends AppCompatActivity implements ShowTicketsView {

    @InjectView(R.id.et_searchAddress)
    EditText etSearchAddress;
    @InjectView(R.id.et_searchHomeowner)
    EditText etSearchHomeowner;
    @InjectView(R.id.bt_submit)
    Button btSubmit;
    @InjectView(R.id.bt_cancel)
    Button btCancel;
    @InjectView(R.id.lv_result)
    ListView lvResult;
    @InjectView(R.id.pb_submit)
    ProgressBar pbSubmit;
    private TicketsAdapter ticketsAdapter;
    private SearchTicketsPresenter searchTicketsPresenter;
    private List<HomevendorDat> listHomevendorDat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_tickets);
        HaustalkApplication.getInstance().addActivity(this);
        ButterKnife.inject(this);
        UiTools.setBackActionBarLayout(this, "Search Tickets");
        searchTicketsPresenter = new SearchTicketstPresenterImpl(this);
        ticketsAdapter = new TicketsAdapter(this, null);
        lvResult.setAdapter(ticketsAdapter);
        lvResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(listHomevendorDat!=null) {
                    HomevendorDat homevendorDat = listHomevendorDat.get(position);
                    Intent intent = new Intent();
                    intent.putExtra("idwebcare1", homevendorDat.getIdwebcare1());
                    intent.putExtra("idcia", homevendorDat.getIdcia());
                    intent.setClass(SearchTicketsActivity.this, PmticketviewActivity.class);
                    SearchTicketsActivity.this.startActivity(intent);
                    overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                }
            }
        });
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etSearchAddress.getText().toString().equals("") && etSearchHomeowner.getText().toString().equals("")) {
                    return;
                }
                pbSubmit.setVisibility(View.VISIBLE);
                Login login = HaustalkApplication.getLogin();
                Req_ba_searchticketpm req_ba_searchticketpm = new Req_ba_searchticketpm();
                req_ba_searchticketpm.setAddress(etSearchAddress.getText().toString());
                req_ba_searchticketpm.setHomeowner(etSearchHomeowner.getText().toString());
                req_ba_searchticketpm.setStatus("");
                req_ba_searchticketpm.setToken(login.getToken());
                req_ba_searchticketpm.setTokensecret(login.getTokensecret());
                searchTicketsPresenter.searchTickets(req_ba_searchticketpm);
            }
        });
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
        this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

    @Override
    public void showResult(Homevendor result) {
        this.listHomevendorDat = result.getProjects();
        this.ticketsAdapter.setContent(this.listHomevendorDat);
        this.ticketsAdapter.notifyDataSetChanged();
        pbSubmit.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {
        pbSubmit.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), error,
                Toast.LENGTH_SHORT).show();
    }
}
