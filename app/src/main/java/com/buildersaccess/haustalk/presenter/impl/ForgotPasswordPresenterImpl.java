package com.buildersaccess.haustalk.presenter.impl;

import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.model.dao.Model;
import com.buildersaccess.haustalk.model.dao.impl.ModelImpl;
import com.buildersaccess.haustalk.model.entity.Forgotpassword;
import com.buildersaccess.haustalk.model.entity.Req_forgotpassword;
import com.buildersaccess.haustalk.model.entity.Req_step1;
import com.buildersaccess.haustalk.model.entity.Step1;
import com.buildersaccess.haustalk.presenter.CreateAccountPresenter;
import com.buildersaccess.haustalk.presenter.ForgotPasswordPresenter;
import com.buildersaccess.haustalk.presenter.OnCreateAccountListener;
import com.buildersaccess.haustalk.presenter.OnForgotPasswordListener;
import com.buildersaccess.haustalk.ui.view.CreateAccountView;
import com.buildersaccess.haustalk.ui.view.ForgotPassWordView;

import retrofit.RetrofitError;

/**
 * Created by pangg_000 on 11/7/2015.
 */
public class ForgotPasswordPresenterImpl implements ForgotPasswordPresenter,OnForgotPasswordListener{


    private Model model;
    private ForgotPassWordView forgotPassWordView;

    public ForgotPasswordPresenterImpl(ForgotPassWordView forgotPassWordView) {
        this.forgotPassWordView = forgotPassWordView;
        this.model=new ModelImpl();
    }

    @Override
    public void forgotpassword(Req_forgotpassword req_forgotpassword) {
        this.model.forgotpassword(req_forgotpassword,this);
    }

    @Override
    public void OnForgotPasswordSuccess(Forgotpassword result) {
        try {
            if (result.getEmailhomeowner().equals("1")) {
                this.forgotPassWordView.showResult(result);
            } else {
                this.forgotPassWordView.showError(result.getMessage());
            }
        }catch (Exception e){
            this.forgotPassWordView.showError(e.getMessage());
        }
    }

    @Override
    public void onError(RetrofitError retrofitError) {
        this.forgotPassWordView.showError(retrofitError.getMessage());
    }
}
