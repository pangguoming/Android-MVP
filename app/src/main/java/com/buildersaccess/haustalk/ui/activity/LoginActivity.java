package com.buildersaccess.haustalk.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import com.buildersaccess.haustalk.R;
import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.model.entity.Req_login;
import com.buildersaccess.haustalk.presenter.LoginPresenter;
import com.buildersaccess.haustalk.presenter.impl.LoginPresenterImpl;
import com.buildersaccess.haustalk.ui.view.LoginView;
import com.buildersaccess.haustalk.utility.UiTools;
import com.buildersaccess.haustalk.utility.storage.DAO;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @InjectView(R.id.et_email)
    EditText etEmail;
    @InjectView(R.id.et_password)
    EditText etPassword;
    @InjectView(R.id.sw_rememberme)
    Switch swRememberme;
    @InjectView(R.id.bt_login)
    Button btLogin;
    @InjectView(R.id.tv_create)
    TextView tvCreate;
    @InjectView(R.id.tv_forgot)
    TextView tvForgot;
    @InjectView(R.id.tv_message)
    TextView tvMessage;
    @InjectView(R.id.bt_closemessage)
    ImageButton btClosemessage;
    @InjectView(R.id.ll_messagebox)
    LinearLayout llMessagebox;
    @InjectView(R.id.pb_login)
    ProgressBar pbLogin;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HaustalkApplication.getInstance().addActivity(this);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        loginPresenter = new LoginPresenterImpl(this);
        UiTools.setActionBarLayout(this, "Haustalk");

        Req_login req_login=DAO.getAccount(this);
        this.etEmail.setText(req_login.getEmail());
        if(!req_login.getPassword().equals("")){
            this.etPassword.setText(req_login.getPassword());
            swRememberme.setChecked(true);
        }

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etEmail.getText().toString().equals("")&&etPassword.getText().toString().equals("")){
                    return;
                }
                btLogin.setClickable(false);
                pbLogin.setVisibility(View.VISIBLE);
                Req_login req_login = new Req_login();
                req_login.setEmail(etEmail.getText().toString());
                req_login.setPassword(etPassword.getText().toString());
                req_login.setDevicetoken(" ");
                req_login.setIosyn("1");
                req_login.setWebyn("0");
                if(swRememberme.isChecked()){
                    DAO.saveAccount(LoginActivity.this,req_login);
                }else{
                    DAO.cleanPassword(LoginActivity.this);
                }

                loginPresenter.login(req_login);
            }
        });
        btClosemessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llMessagebox.setVisibility(View.GONE);
                btLogin.setClickable(true);
            }
        });
        tvCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, CreateAccountActivity.class);
                LoginActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                pbLogin.setVisibility(View.GONE);
                btLogin.setClickable(true);
            }
        });
        tvForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, ForgotActivity.class);
                LoginActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                pbLogin.setVisibility(View.GONE);
                btLogin.setClickable(true);
            }
        });
/*        swRememberme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                Req_login req_login=new Req_login();
                req_login.setEmail(etEmail.getText().toString());
                req_login.setPassword(etPassword.getText().toString());
                if (isChecked) {
                    DAO.saveAccount(LoginActivity.this,req_login);
                } else {
                    DAO.cleanPassword(LoginActivity.this);
                }
            }
        });*/
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this, PmhomeActivity.class);
        LoginActivity.this.startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        btLogin.setClickable(true);
        pbLogin.setVisibility(View.GONE);
        LoginActivity.this.finish();
    }

    @Override
    public void showError(String error) {
        pbLogin.setVisibility(View.GONE);
        btLogin.setClickable(true);
        tvMessage.setText(error);
        llMessagebox.setVisibility(View.VISIBLE);
    }
}
