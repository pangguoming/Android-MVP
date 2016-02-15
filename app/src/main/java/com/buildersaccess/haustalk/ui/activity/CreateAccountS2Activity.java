package com.buildersaccess.haustalk.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.buildersaccess.haustalk.R;
import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.utility.UiTools;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CreateAccountS2Activity extends AppCompatActivity {

    @InjectView(R.id.et_firstname)
    EditText etFirstname;
    @InjectView(R.id.et_lastname)
    EditText etLastname;
    @InjectView(R.id.et_phone)
    EditText etPhone;
    @InjectView(R.id.et_alphone)
    EditText etAlphone;
    @InjectView(R.id.et_password)
    EditText etPassword;
    @InjectView(R.id.et_confirm)
    EditText etConfirm;
    @InjectView(R.id.bt_continue)
    Button btContinue;
    @InjectView(R.id.pb_continue)
    ProgressBar pbContinue;
    @InjectView(R.id.sp_time)
    Spinner spTime;
    private ArrayAdapter<String> sp_adapter;
    private static final String[] spData={"--Any time--","Morning","Afternoon"};
    private String time="Morning";
    private String email="";
    private String address="";
    private String closed="";
    private String idcia="";
    private String idproject="";
    private String namecity="";
    private String idcity="";
    private String serverdate="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HaustalkApplication.getInstance().addActivity(this);
        Intent intent = getIntent();
        this.serverdate=intent.getStringExtra("serverdate");
        this.idcia=intent.getStringExtra("idcia");
        this.idproject=intent.getStringExtra("idproject");
        this.namecity=intent.getStringExtra("namecity");
        this.idcity=intent.getStringExtra("idcity");
        this.closed=intent.getStringExtra("closed");
        this.email=intent.getStringExtra("email");
        this.address=intent.getStringExtra("address");
        setContentView(R.layout.activity_create_account_s2);
        ButterKnife.inject(this);
        UiTools.setBackActionBarLayout(this, "Create An Account");
        sp_adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,spData);
        spTime.setAdapter(sp_adapter);
        spTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                time = spData[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etPassword.getText().toString().equals(etConfirm.getText().toString())) {
                    Intent intent = new Intent();
                    intent.putExtra("fname", etFirstname.getText().toString());
                    intent.putExtra("lname",etLastname.getText().toString());
                    intent.putExtra("phone", etPhone.getText().toString());
                    intent.putExtra("alphone", etAlphone.getText().toString());
                    intent.putExtra("password", etPassword.getText().toString());
                    intent.putExtra("time", time);

                    intent.putExtra("serverdate",serverdate);
                    intent.putExtra("idcia",idcia);
                    intent.putExtra("idproject",idproject);
                    intent.putExtra("namecity",namecity);
                    intent.putExtra("idcity",idcity);
                    intent.putExtra("closed",closed);
                    intent.putExtra("email",email);
                    intent.putExtra("address", address);

                    intent.setClass(CreateAccountS2Activity.this, CreateAccountS3Activity.class);
                    CreateAccountS2Activity.this.startActivity(intent);
                    overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                    //CreateAccountS2Activity.this.finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Password confirm error.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
        this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

}
