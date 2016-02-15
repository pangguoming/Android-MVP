package com.buildersaccess.haustalk.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.buildersaccess.haustalk.R;
import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.model.entity.CMessage;
import com.buildersaccess.haustalk.utility.UiTools;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MessageLogActivity extends AppCompatActivity {
    ;
    @InjectView(R.id.ll_main)
    LinearLayout llMain;
    private List<CMessage> cMessageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_log);
        ButterKnife.inject(this);
        HaustalkApplication.getInstance().addActivity(this);
        UiTools.setBackActionBarLayout(this, "Message Log");
        try{
            cMessageList = PmticketviewActivity.getcMessageList();
            for (CMessage item : cMessageList) {
                LinearLayout itembox = new LinearLayout(this);
                itembox.setOrientation(LinearLayout.HORIZONTAL);
                itembox.setBackgroundResource(R.drawable.linearlayout_bottom_gray_border);
                itembox.setPadding(0, 60, 0, 60);
                TextView textView = new TextView(this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.weight = 1.0f;
                textView.setLayoutParams(params);
                textView.setText("Sent: " + item.getCreadate() + "\nFrom: " + item.getCreaby() + "\nTo: " + item.getEmailto2() + "\n" + item.getNotes().replace("<br>", "\n"));
                itembox.addView(textView);

                if(item.getEmailto2().equals("Post Comment")&&item.getCallflag().equals("True")){
                    ImageView ivEmail = new ImageView(this);
                    ivEmail.setImageResource(R.mipmap.ic_gray_phone);
                    itembox.addView(ivEmail);
                }
                if(!item.getEmailto2().equals("Post Comment")){
                    ImageView ivEmail = new ImageView(this);
                    if(item.getAcknowledgedate().indexOf("1980")!=-1){
                        ivEmail.setImageResource(R.mipmap.ic_gray_email);
                        itembox.addView(ivEmail);
                    }else{
                        ivEmail.setImageResource(R.mipmap.ic_gray_email_open);
                        itembox.addView(ivEmail);
                    }

                }

                llMain.addView(itembox);
            }
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
