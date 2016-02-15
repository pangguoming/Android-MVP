package com.buildersaccess.haustalk.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.buildersaccess.haustalk.R;
import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.model.api.REST_API;
import com.buildersaccess.haustalk.model.entity.Ba_ticketpm;
import com.buildersaccess.haustalk.model.entity.CMessage;
import com.buildersaccess.haustalk.model.entity.Login;
import com.buildersaccess.haustalk.model.entity.Req_ba_ticketpm;
import com.buildersaccess.haustalk.presenter.PmticketviewPresenter;
import com.buildersaccess.haustalk.presenter.impl.PmticketviewPresenterImpl;
import com.buildersaccess.haustalk.ui.view.PmticketviewView;
import com.buildersaccess.haustalk.utility.RetrofitApiAdapter;
import com.buildersaccess.haustalk.utility.UiTools;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

public class PmticketviewActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, PmticketviewView {

    @InjectView(R.id.tv_time)
    TextView tvTime;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_company)
    TextView tvCompany;
    @InjectView(R.id.iv_user)
    ImageView ivUser;
    @InjectView(R.id.ll_showmap)
    LinearLayout llShowmap;
    @InjectView(R.id.tv_address)
    TextView tvAddress;
    @InjectView(R.id.ib_show_address_detail)
    ImageButton ibShowAddressDetail;
    @InjectView(R.id.tv_address_detail)
    TextView tvAddressDetail;
    @InjectView(R.id.ll_address_detail)
    LinearLayout llAddressDetail;
    @InjectView(R.id.ll_show_message)
    LinearLayout llShowMessage;
    @InjectView(R.id.ll_servicebox)
    LinearLayout llServicebox;
    @InjectView(R.id.srl_main)
    SwipeRefreshLayout srlMain;
    @InjectView(R.id.tv_followup)
    TextView tvFollowup;
    @InjectView(R.id.iv_followup)
    ImageView ivFollowup;
    @InjectView(R.id.ll_followup)
    LinearLayout llFollowup;
    @InjectView(R.id.tv_callmanager)
    TextView tvCallmanager;
    @InjectView(R.id.ll_callmanager)
    LinearLayout llCallmanager;
    @InjectView(R.id.tv_emailmananger)
    TextView tvEmailmananger;
    @InjectView(R.id.ll_emailmanager)
    LinearLayout llEmailmanager;
    @InjectView(R.id.tv_assignproject)
    TextView tvAssignproject;
    @InjectView(R.id.ll_assignproject)
    LinearLayout llAssignproject;
    @InjectView(R.id.tv_assignfollowup)
    TextView tvAssignfollowup;
    @InjectView(R.id.ll_project_btbox)
    LinearLayout llProjectBtbox;
    @InjectView(R.id.ll_email_homeowner)
    LinearLayout llEmailHomeowner;
    @InjectView(R.id.ll_selectioncolor)
    LinearLayout llSelectioncolor;
    @InjectView(R.id.ll_address_btbox)
    LinearLayout llAddressBtbox;
    @InjectView(R.id.tv_callfollowup)
    TextView tvCallfollowup;
    @InjectView(R.id.ll_callfollowup)
    LinearLayout llCallfollowup;
    @InjectView(R.id.tv_emailfollowup)
    TextView tvEmailfollowup;
    @InjectView(R.id.ll_emailfollowup)
    LinearLayout llEmailfollowup;
    @InjectView(R.id.ll_assignfollowup)
    LinearLayout llAssignfollowup;
    @InjectView(R.id.ll_followup_btnbox)
    LinearLayout llFollowupBtnbox;
    @InjectView(R.id.ll_call_homeowner)
    LinearLayout llCallHomeowner;
    @InjectView(R.id.ll_postmsg)
    LinearLayout llPostmsg;


    private PmticketviewPresenter pmticketviewPresenter;

    private static List<CMessage> cMessageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pmticketview);
        HaustalkApplication.getInstance().addActivity(this);
        ButterKnife.inject(this);
        UiTools.setBackActionBarLayout(this, "Tickets");
        llAddressDetail.setVisibility(View.GONE);
        ivUser.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
        this.ibShowAddressDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (llAddressDetail.getVisibility() == View.GONE) {
                    llAddressDetail.setVisibility(View.VISIBLE);
                    ibShowAddressDetail.setImageResource(R.mipmap.ic_minus);
                } else {
                    llAddressDetail.setVisibility(View.GONE);
                    ibShowAddressDetail.setImageResource(R.mipmap.ic_add);
                }
            }
        });
        llShowMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cMessageList == null) return;
                Intent intent = new Intent();
                intent.setClass(PmticketviewActivity.this, MessageLogActivity.class);
                PmticketviewActivity.this.startActivity(intent);
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
    }

    @Override
    public void onRefresh() {
        pmticketviewPresenter = new PmticketviewPresenterImpl(this);
        Intent intent = getIntent();
        Login login = HaustalkApplication.getLogin();
        Req_ba_ticketpm req_ba_ticketpm = new Req_ba_ticketpm();
        req_ba_ticketpm.setToken(login.getToken());
        req_ba_ticketpm.setTokensecret(login.getTokensecret());
        req_ba_ticketpm.setIdwebcare1(intent.getStringExtra("idwebcare1"));
        pmticketviewPresenter.ba_ticketpm(req_ba_ticketpm);
    }

    public static List<CMessage> getcMessageList() {
        return cMessageList;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
        this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

    @Override
    public void showPmticket(Ba_ticketpm ba_ticketpm) {
        boolean showPmticket = false;
        if (ba_ticketpm.getTicket().getAssigemail().equals(HaustalkApplication.getReq_login().getEmail()) ||
                ba_ticketpm.getTicket().getFollowupemail().equals(HaustalkApplication.getReq_login().getEmail()) ||
                HaustalkApplication.getLogin().getAdminyn().equals("1")) {
            showPmticket = true;
        }
        this.cMessageList = ba_ticketpm.getListmessage();
        llServicebox.removeAllViews();
        UiTools.setBackActionBarLayout(this, "Tickets # " + ba_ticketpm.getTicket().getIdwebcare1() + " " + ba_ticketpm.getTicket().getStatus());
        //此处直接调用Model层，打乱MVP模式。
        REST_API rest_api = RetrofitApiAdapter.getInstance().create(REST_API.class);
        rest_api.pmphoto(ba_ticketpm.getTicket().getAssigemail(), new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                byte[] data = ((TypedByteArray) response.getBody()).getBytes();
                Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                ivUser.setImageBitmap(bitmap);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                retrofitError.printStackTrace();
            }
        });


        this.tvTime.setText(ba_ticketpm.getTicket().getCreadate());
        this.tvName.setText(ba_ticketpm.getTicket().getAssignpm());
        this.tvCompany.setText(ba_ticketpm.getTicket().getCianame());
        if (showPmticket) {
            this.tvCallmanager.setText("Call " + ba_ticketpm.getTicket().getAssignpm().split(" ")[0]);
            this.llCallmanager.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            this.tvEmailmananger.setText("Email " + ba_ticketpm.getTicket().getAssignpm().split(" ")[0]);
            this.llCallmanager.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            String text = "Assign";
            if (!ba_ticketpm.getTicket().getAssignto().equals("")) {
                text = "Reassign";
            }
            this.tvAssignproject.setText(text + " Project Manager");
            this.llAssignproject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            this.llProjectBtbox.setVisibility(View.VISIBLE);
        }
        if (!ba_ticketpm.getTicket().getFollowup().equals("")) {
            tvFollowup.setText(ba_ticketpm.getTicket().getFollowupname());
            rest_api.pmphoto(ba_ticketpm.getTicket().getFollowupemail(), new Callback<Response>() {
                @Override
                public void success(Response response, Response response2) {
                    byte[] data = ((TypedByteArray) response.getBody()).getBytes();
                    Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                    ivFollowup.setImageBitmap(bitmap);
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    retrofitError.printStackTrace();
                }
            });
            if (showPmticket) {
                this.tvCallfollowup.setText("Call " + ba_ticketpm.getTicket().getFollowupname().split(" ")[0]);
                this.llCallfollowup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                this.tvEmailfollowup.setText("Email " + ba_ticketpm.getTicket().getFollowupname().split(" ")[0]);
                this.llEmailfollowup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                String text = "Assign";
                if (!ba_ticketpm.getTicket().getFollowup().equals("")) {
                    text = "Reassign";
                }
                this.tvAssignfollowup.setText(text + " Project Manager");
                this.llAssignfollowup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                this.llFollowupBtnbox.setVisibility(View.VISIBLE);
            }
            llFollowup.setVisibility(View.VISIBLE);
        }
        this.tvAddress.setText(ba_ticketpm.getTicket().getAddress() + "\n" + ba_ticketpm.getTicket().getCusname());
        this.tvAddressDetail.setText("Closed: " + ba_ticketpm.getTicket().getClosed() + "\n" + "Slab: " + ba_ticketpm.getTicket().getSlab() + "\nBest Time to Contact You :\n" + ba_ticketpm.getTicket().getContactby() + "\n1st Date to Access Your Home: \n" + ba_ticketpm.getTicket().getBestdate1() + " " + ba_ticketpm.getTicket().getBestdate1time() + "\n2nd Date to Access Your Home :\n" + ba_ticketpm.getTicket().getBestdate2() + " " + ba_ticketpm.getTicket().getBestdate2time());
        if (showPmticket) {
            this.llCallHomeowner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            this.llEmailHomeowner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            this.llSelectioncolor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            this.llAddressBtbox.setVisibility(View.VISIBLE);
        }
        int i = 1;
        for (Ba_ticketpm.cTicketDetail item : ba_ticketpm.getListticketdetail()) {
            LinearLayout llbox = new LinearLayout(this);
            llbox.setOrientation(LinearLayout.VERTICAL);
            llbox.setBackgroundResource(R.drawable.linearlayout_gray_border);
            llbox.setPadding(20, 20, 20, 20);
            LinearLayout.LayoutParams box_params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            box_params.setMargins(0, 0, 0, 10);
            llbox.setLayoutParams(box_params);
            LinearLayout lltop = new LinearLayout(this);
            lltop.setOrientation(LinearLayout.HORIZONTAL);
            lltop.setPadding(0, 0, 0, 40);
            LinearLayout llmessbox = new LinearLayout(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.weight = 1.0f;
            llmessbox.setLayoutParams(params);
            llmessbox.setOrientation(LinearLayout.VERTICAL);
            TextView tvTitle = new TextView(this);
            tvTitle.setTextColor(Color.rgb(0, 0, 0));
            tvTitle.setText("Request " + i + " " + item.getStatus2() + "\n" + item.getCatdescription());
            llmessbox.addView(tvTitle);
            TextView tvSubTitle = new TextView(this);
            tvSubTitle.setText(item.getServicenotes());
            llmessbox.addView(tvSubTitle);
            lltop.addView(llmessbox);
            final ImageButton ibSwitch = new ImageButton(this);
            ibSwitch.setBackgroundResource(R.color.transparent);
            ibSwitch.setImageResource(R.mipmap.ic_add);
            lltop.addView(ibSwitch);
            llbox.addView(lltop);
            final LinearLayout llbottom = new LinearLayout(this);
            llbottom.setOrientation(LinearLayout.VERTICAL);
            llbottom.setLayoutParams(params);
            int j = 1;
            for (Ba_ticketpm.cTicketDetail.cTask cTask : item.getListtask()) {
                LinearLayout llbottomitem = new LinearLayout(this);
                llbottomitem.setPadding(0, 0, 0, 40);
                llbottomitem.setOrientation(LinearLayout.HORIZONTAL);
                llbottomitem.setLayoutParams(params);
                LinearLayout llbottomitemleft = new LinearLayout(this);
                llbottomitemleft.setOrientation(LinearLayout.VERTICAL);
                llbottomitemleft.setLayoutParams(params);
                TextView tvBtTitle = new TextView(this);
                tvBtTitle.setTextColor(Color.rgb(0, 0, 0));
                tvBtTitle.setText("Task " + i + "." + j);
                llbottomitemleft.addView(tvBtTitle);
                TextView tvBtSubTitle = new TextView(this);
                tvBtSubTitle.setText(cTask.getNvendor() + "\n" + cTask.getVendorcontact() + "\nDuration : " + cTask.getDuration() + " days\nStatus : " + cTask.getStatus() + "\nScheduled :\n" + cTask.getVendorschedule() + " @ " + cTask.getSchedulebesttime() + "\nTo Do :\n" + cTask.getBuildernotes());
                llbottomitemleft.addView(tvBtSubTitle);

                final ImageView itemImage = new ImageView(this);
                itemImage.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
                //此处直接调用Model层，打乱MVP模式。
                rest_api.vendorphoto(cTask.getVendoremail(), new Callback<Response>() {
                    @Override
                    public void success(Response response, Response response2) {
                        byte[] data = ((TypedByteArray) response.getBody()).getBytes();
                        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                        itemImage.setImageBitmap(bitmap);
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {
                        retrofitError.printStackTrace();
                    }
                });
                llbottomitem.addView(llbottomitemleft);
                llbottomitem.addView(itemImage);
                llbottom.addView(llbottomitem);
                j++;
            }

            LinearLayout.LayoutParams lpBtn = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lpBtn.weight = 1.0f;
            lpBtn.setMargins(6, 6, 6, 6);
            LinearLayout llTaskPhoto = new LinearLayout(this);
            llTaskPhoto.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout llTask = new LinearLayout(this);
            llTask.setLayoutParams(lpBtn);
            llTask.setOrientation(LinearLayout.HORIZONTAL);
            llTask.setPadding(20, 20, 20, 20);
            llTask.setBackgroundResource(R.color.colorPrimary);
            TextView tvTask = new TextView(this);
            tvTask.setLayoutParams(params);
            tvTask.setTextColor(Color.rgb(255, 255, 255));
            tvTask.setText("Task");
            llTask.addView(tvTask);
            ImageView ivTask = new ImageView(this);
            ivTask.setImageResource(R.mipmap.ic_edit);
            llTask.addView(ivTask);
            llTaskPhoto.addView(llTask);

            LinearLayout llCamera= new LinearLayout(this);
            llCamera.setOrientation(LinearLayout.HORIZONTAL);
            llCamera.setLayoutParams(lpBtn);
            llCamera.setPadding(20, 20, 20, 20);
            llCamera.setBackgroundResource(R.color.colorPrimary);
            TextView tvCamera = new TextView(this);
            tvCamera.setTextColor(Color.rgb(255, 255, 255));
            tvCamera.setLayoutParams(params);
            tvCamera.setText("Photo");
            llCamera.addView(tvCamera);
            ImageView ivCamera = new ImageView(this);
            ivCamera.setImageResource(R.mipmap.ic_camera);
            llCamera.addView(ivCamera);
            llTaskPhoto.addView(llCamera);

            llbottom.addView(llTaskPhoto);

            LinearLayout llHome= new LinearLayout(this);
            llHome.setOrientation(LinearLayout.HORIZONTAL);
            llHome.setLayoutParams(lpBtn);
            llHome.setPadding(20, 20, 20, 20);
            llHome.setBackgroundResource(R.color.gold);
            TextView tvHome = new TextView(this);
            tvHome.setTextColor(Color.rgb(255, 255, 255));
            tvHome.setLayoutParams(params);
            tvHome.setText("Report owner not home");
            llHome.addView(tvHome);
            ImageView ivHome = new ImageView(this);
            ivHome.setImageResource(R.mipmap.ic_house);
            llHome.addView(ivHome);
            llbottom.addView(llHome);

            LinearLayout llFlag= new LinearLayout(this);
            llFlag.setOrientation(LinearLayout.HORIZONTAL);
            llFlag.setLayoutParams(lpBtn);
            llFlag.setPadding(20,20,20,20);
            llFlag.setBackgroundResource(R.color.crimson);
            TextView tvFlag = new TextView(this);
            tvFlag.setTextColor(Color.rgb(255, 255, 255));
            tvFlag.setLayoutParams(params);
            tvFlag.setText("Non-Warrantable");
            llFlag.addView(tvFlag);
            ImageView ivFlag = new ImageView(this);
            ivFlag.setImageResource(R.mipmap.ic_flag);
            llFlag.addView(ivFlag);
            llbottom.addView(llFlag);


            llbottom.setVisibility(View.GONE);
            ibSwitch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (llbottom.getVisibility() == View.GONE) {
                        llbottom.setVisibility(View.VISIBLE);
                        ibSwitch.setImageResource(R.mipmap.ic_minus);
                    } else {
                        llbottom.setVisibility(View.GONE);
                        ibSwitch.setImageResource(R.mipmap.ic_add);
                    }
                }
            });
            llbox.addView(llbottom);
            i++;
            llServicebox.addView(llbox);
        }
        if (showPmticket) {
            llPostmsg.setVisibility(View.VISIBLE);
            llPostmsg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        srlMain.setRefreshing(false);
    }

    @Override
    public void showError(String error) {
        srlMain.setRefreshing(false);
        Toast.makeText(getApplicationContext(), error,
                Toast.LENGTH_SHORT).show();
    }

}
