package com.buildersaccess.haustalk.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.buildersaccess.haustalk.R;
import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.model.entity.Forgotpassword;
import com.buildersaccess.haustalk.model.entity.Req_forgotpassword;
import com.buildersaccess.haustalk.presenter.ForgotPasswordPresenter;
import com.buildersaccess.haustalk.presenter.impl.ForgotPasswordPresenterImpl;
import com.buildersaccess.haustalk.ui.view.ForgotPassWordView;
import com.buildersaccess.haustalk.utility.UiTools;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ForgotActivity extends AppCompatActivity implements ForgotPassWordView {

    @InjectView(R.id.et_email)
    EditText etEmail;
    @InjectView(R.id.bt_continue)
    Button btContinue;
    @InjectView(R.id.pb_submit)
    ProgressBar pbSubmit;
    private ForgotPasswordPresenter forgotPasswordPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        ButterKnife.inject(this);
        HaustalkApplication.getInstance().addActivity(this);
        forgotPasswordPresenter=new ForgotPasswordPresenterImpl(this);
        UiTools.setBackActionBarLayout(this, "Forgot Password ?");
        btContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbSubmit.setVisibility(View.VISIBLE);
                Req_forgotpassword req_forgotpassword= new Req_forgotpassword();
                req_forgotpassword.setEmail(etEmail.getText().toString());
                forgotPasswordPresenter.forgotpassword(req_forgotpassword);
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
    public void showResult(Forgotpassword result) {
        pbSubmit.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), result.getMessage(),
                Toast.LENGTH_SHORT).show();
        this.onBackPressed();
    }

    @Override
    public void showError(String error) {
        pbSubmit.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), error,
                Toast.LENGTH_SHORT).show();
    }
}
