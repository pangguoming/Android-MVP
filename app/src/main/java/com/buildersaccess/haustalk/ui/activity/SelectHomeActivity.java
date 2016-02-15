package com.buildersaccess.haustalk.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.buildersaccess.haustalk.R;
import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.model.entity.Step1;
import com.buildersaccess.haustalk.ui.adapter.SelectHomeAdapter;
import com.buildersaccess.haustalk.utility.UiTools;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SelectHomeActivity extends AppCompatActivity {

    @InjectView(R.id.lv_main)
    ListView lvMain;
    private SelectHomeAdapter selectHomeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_home);
        HaustalkApplication.getInstance().addActivity(this);
        UiTools.setBackActionBarLayout(this, "Create An Account");
        ButterKnife.inject(this);
        HaustalkApplication.getInstance().addActivity(this);
        try {
            selectHomeAdapter = new SelectHomeAdapter(this, CreateAccountActivity.getStep1().getcAddress());
            lvMain.setAdapter(selectHomeAdapter);

            lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Step1.cAddressDat cAddressDat = CreateAccountActivity.getStep1().getcAddress().get(position);
                    Intent intent = new Intent();
                    Intent intentIn = getIntent();
                    intent.putExtra("serverdate", CreateAccountActivity.getStep1().getServerdate());
                    intent.putExtra("idcia", cAddressDat.getIdcia());
                    intent.putExtra("idproject", cAddressDat.getIdproject());
                    intent.putExtra("address", cAddressDat.getAddress());
                    intent.putExtra("namecity", cAddressDat.getNamecity());
                    intent.putExtra("idcity", cAddressDat.getIdcity());
                    intent.putExtra("closed", cAddressDat.getClosed());
                    intent.putExtra("email", intentIn.getStringExtra("email"));
                    intent.setClass(SelectHomeActivity.this, CreateAccountS2Activity.class);
                    SelectHomeActivity.this.startActivity(intent);
                    overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                }
            });
        }catch (Exception e){
            this.showError(e.getMessage());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
        this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }
    public void showError(String error) {
        Toast.makeText(getApplicationContext(), error,
                Toast.LENGTH_SHORT).show();
    }
}
