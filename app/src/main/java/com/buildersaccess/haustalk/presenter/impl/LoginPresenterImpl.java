package com.buildersaccess.haustalk.presenter.impl;

import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.model.dao.Model;
import com.buildersaccess.haustalk.model.dao.impl.ModelImpl;
import com.buildersaccess.haustalk.model.entity.Login;
import com.buildersaccess.haustalk.model.entity.Req_login;
import com.buildersaccess.haustalk.presenter.LoginPresenter;
import com.buildersaccess.haustalk.presenter.OnLoginListener;
import com.buildersaccess.haustalk.ui.view.LoginView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit.RetrofitError;

/**
 * Created by pangg_000 on 11/7/2015.
 */
public class LoginPresenterImpl implements LoginPresenter,OnLoginListener {
    private Model model;
    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.model=new ModelImpl();
    }

    @Override
    public void login(Req_login req_login) {
        HaustalkApplication.setReq_login(req_login);
        this.model.login(req_login,this);
    }

    @Override
    public void onLoginSuccess(Login result) {
        try {
            if (result.isActiveyn()) {
                HaustalkApplication.setLogin(result);
                this.loginView.loginSuccess();
            } else {
                this.loginView.showError(result.getMessage());
            }
        }catch (Exception e){
            this.loginView.showError(e.getMessage());
        }
    }

    @Override
    public void onError(RetrofitError retrofitError) {
        this.loginView.showError(retrofitError.getMessage());
    }

}
