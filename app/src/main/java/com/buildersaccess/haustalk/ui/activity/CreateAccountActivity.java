package com.buildersaccess.haustalk.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.buildersaccess.haustalk.R;
import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.model.entity.Req_step1;
import com.buildersaccess.haustalk.model.entity.Step1;
import com.buildersaccess.haustalk.presenter.CreateAccountPresenter;
import com.buildersaccess.haustalk.presenter.impl.CreateAccountPresenterImpl;
import com.buildersaccess.haustalk.ui.view.CreateAccountView;
import com.buildersaccess.haustalk.utility.UiTools;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CreateAccountActivity extends AppCompatActivity implements CreateAccountView {

    @InjectView(R.id.et_email)
    EditText etEmail;
    @InjectView(R.id.et_address)
    EditText etAddress;
    @InjectView(R.id.et_year)
    EditText etYear;
    @InjectView(R.id.bt_continue)
    Button btContinue;
    @InjectView(R.id.pb_continue)
    ProgressBar pbContinue;
    private CreateAccountPresenter createAccountPresenter;
    private static Step1 step1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HaustalkApplication.getInstance().addActivity(this);
        setContentView(R.layout.activity_create_account);
        ButterKnife.inject(this);
        createAccountPresenter=new CreateAccountPresenterImpl(this);
        UiTools.setBackActionBarLayout(this, "Create An Account");

        btContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbContinue.setVisibility(View.VISIBLE);
                Req_step1 req_step1 = new Req_step1();
                req_step1.setAddress(etAddress.getText().toString());
                req_step1.setYear(etYear.getText().toString());
                createAccountPresenter.step1(req_step1);
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
    public void gotoStep2(Step1 result) {

        Step1.cAddressDat cAddressDat= result.getcAddress().get(0);
        Intent intent = new Intent();
        intent.putExtra("serverdate", result.getServerdate());
        intent.putExtra("idcia", cAddressDat.getIdcia());
        intent.putExtra("idproject",cAddressDat.getIdproject());
        intent.putExtra("address",cAddressDat.getAddress());
        intent.putExtra("namecity",cAddressDat.getNamecity());
        intent.putExtra("idcity",cAddressDat.getIdcity());
        intent.putExtra("closed",cAddressDat.getClosed());
        intent.putExtra("email", etEmail.getText().toString());
        intent.setClass(CreateAccountActivity.this, CreateAccountS2Activity.class);
        CreateAccountActivity.this.startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);

        pbContinue.setVisibility(View.GONE);
        //this.finish();
    }

    public static Step1 getStep1(){
        return step1;
    }

    @Override
    public void gotoSelectHome(Step1 result) {
        CreateAccountActivity.step1=result;
        Intent intent = new Intent();
        intent.putExtra("email", etEmail.getText().toString());
        intent.setClass(CreateAccountActivity.this, SelectHomeActivity.class);
        CreateAccountActivity.this.startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }

    @Override
    public void gotoFinish() {

    }
    @Override
    public void showError(String error) {
        pbContinue.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), error,
                Toast.LENGTH_SHORT).show();
    }
}
