package com.buildersaccess.haustalk.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.buildersaccess.haustalk.R;
import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.model.entity.Req_step2;
import com.buildersaccess.haustalk.model.entity.Step1;
import com.buildersaccess.haustalk.presenter.CreateAccountPresenter;
import com.buildersaccess.haustalk.presenter.impl.CreateAccountPresenterImpl;
import com.buildersaccess.haustalk.ui.view.CreateAccountView;
import com.buildersaccess.haustalk.utility.UiTools;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CreateAccountS3Activity extends AppCompatActivity implements CreateAccountView {

    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_email)
    TextView tvEmail;
    @InjectView(R.id.tv_address)
    TextView tvAddress;
    @InjectView(R.id.tv_phone)
    TextView tvPhone;
    @InjectView(R.id.tv_alphone)
    TextView tvAlphone;
    @InjectView(R.id.tv_time)
    TextView tvTime;
    @InjectView(R.id.bt_continue)
    Button btContinue;
    @InjectView(R.id.pb_continue)
    ProgressBar pbContinue;
    private CreateAccountPresenter createAccountPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HaustalkApplication.getInstance().addActivity(this);
        setContentView(R.layout.activity_create_account_s3);
        ButterKnife.inject(this);
        UiTools.setBackActionBarLayout(this, "Create An Account");
        createAccountPresenter=new CreateAccountPresenterImpl(this);
        Intent intent = getIntent();
        this.tvName.setText(intent.getStringExtra("fname")+intent.getStringExtra("lname"));
        this.tvEmail.setText(intent.getStringExtra("email"));
        this.tvAddress.setText(intent.getStringExtra("address"));
        this.tvPhone.setText(intent.getStringExtra("phone"));
        this.tvAlphone.setText(intent.getStringExtra("alphone"));
        this.tvTime.setText(intent.getStringExtra("time"));



        btContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbContinue.setVisibility(View.VISIBLE);

                Intent intent = getIntent();
                Req_step2 req_step2=new Req_step2();
                req_step2.setEmail(tvEmail.getText().toString());
                req_step2.setAddress(tvAddress.getText().toString());
                req_step2.setBesttime(tvTime.getText().toString());
                req_step2.setPhone(tvPhone.getText().toString());
                req_step2.setClosed(intent.getStringExtra("closed"));
                req_step2.setFname(intent.getStringExtra("fname"));
                req_step2.setLname(intent.getStringExtra("lname"));
                req_step2.setConfirm(intent.getStringExtra("password"));
                req_step2.setPassword(intent.getStringExtra("serverdate"));
                req_step2.setIdcia(intent.getStringExtra("idcia"));
                req_step2.setIdcity(intent.getStringExtra("idcity"));
                req_step2.setIdproject(intent.getStringExtra("idproject"));
                req_step2.setNamecity(intent.getStringExtra("namecity"));
                req_step2.setWorkphone(intent.getStringExtra("alphone"));
                req_step2.setIosyn("0");
                req_step2.setCreaby("Homeowner App");
                req_step2.setWebyn("0");
                req_step2.setDevicetoken(" ");

                createAccountPresenter.step2(req_step2);
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

    }

    @Override
    public void gotoFinish() {
        pbContinue.setVisibility(View.GONE);
        Intent intent = new Intent();
        intent.setClass(CreateAccountS3Activity.this, PmhomeActivity.class);
        CreateAccountS3Activity.this.startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        HaustalkApplication.getInstance().closeActivitys();
        //this.finish();
    }

    @Override
    public void gotoSelectHome(Step1 result) {

    }

    @Override
    public void showError(String error) {
        pbContinue.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), error,
                Toast.LENGTH_SHORT).show();
    }
}
