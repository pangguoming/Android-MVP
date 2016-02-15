package com.buildersaccess.haustalk.app;

import android.app.Activity;
import android.app.Application;

import com.buildersaccess.haustalk.model.entity.Login;
import com.buildersaccess.haustalk.model.entity.Req_login;
import com.buildersaccess.haustalk.presenter.impl.LoginPresenterImpl;
import com.buildersaccess.haustalk.utility.volley.MyNetwork;
import com.buildersaccess.haustalk.utility.CheckSettings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/2/6.
 * 替换默认的Application实现
 */
public class HaustalkApplication extends Application {
    private static HaustalkApplication instance;
    private List<Activity> activities ;
    private static Login login;
    private static Req_login req_login;

    public HaustalkApplication() {
        instance = this;
        activities= new ArrayList<Activity>();
    }

    public static HaustalkApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MyNetwork.init(this);
        CheckSettings.init(this);
    }

    public static Req_login getReq_login() {
        return req_login;
    }

    public static void setReq_login(Req_login req_login) {
        HaustalkApplication.req_login = req_login;
    }

    public static Login getLogin() {
        return login;
    }

    public static void setLogin(Login login) {
        HaustalkApplication.login = login;
    }

    public  void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void closeActivitys() {
        for (Activity activity : activities) {
            if (activity != null)
                activity.finish();
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        for (Activity activity : activities) {
            if (activity != null)
            activity.finish();
        }
        System.exit(0);
    }
}
