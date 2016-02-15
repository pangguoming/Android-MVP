package com.buildersaccess.haustalk.presenter.impl;

import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.model.dao.Model;
import com.buildersaccess.haustalk.model.dao.impl.ModelImpl;
import com.buildersaccess.haustalk.model.entity.Login;
import com.buildersaccess.haustalk.model.entity.Req_login;
import com.buildersaccess.haustalk.model.entity.Req_step1;
import com.buildersaccess.haustalk.model.entity.Req_step2;
import com.buildersaccess.haustalk.model.entity.Step1;
import com.buildersaccess.haustalk.presenter.CreateAccountPresenter;
import com.buildersaccess.haustalk.presenter.LoginPresenter;
import com.buildersaccess.haustalk.presenter.OnCreateAccountListener;
import com.buildersaccess.haustalk.presenter.OnLoginListener;
import com.buildersaccess.haustalk.ui.view.CreateAccountView;
import com.buildersaccess.haustalk.ui.view.LoginView;

import retrofit.RetrofitError;

/**
 * Created by pangg_000 on 11/7/2015.
 */
public class CreateAccountPresenterImpl implements CreateAccountPresenter,OnCreateAccountListener {
    private Model model;
    private CreateAccountView createAccountView;

    public CreateAccountPresenterImpl(CreateAccountView createAccountView) {
        this.createAccountView = createAccountView;
        this.model=new ModelImpl();
    }

    @Override
    public void step1(Req_step1 req_step1) {
        this.model.step1(req_step1,this);
    }

    @Override
    public void onCreateAccountSuccess(Step1 step1) {
        try {
            if(step1.getcAddress().size()==1){
                this.createAccountView.gotoStep2(step1);
            }else if(step1.getcAddress().size()>1){
                this.createAccountView.gotoSelectHome(step1);
            }else{
                this.createAccountView.showError(step1.getMessage());
            }
        }catch (Exception e){
            this.createAccountView.showError(e.getMessage());
        }
    }

    @Override
    public void step2(Req_step2 req_step2) {
        this.model.step2(req_step2,this);
    }

    @Override
    public void onCreateAccountS2Success(Login result) {
        try {
            result.setUsername(result.getcAddress().get(0).getOwnername());
            HaustalkApplication.setLogin(result);
            if (result.isActiveyn()) {
                createAccountView.gotoFinish();
            } else {
                this.createAccountView.showError(result.getMessage());
            }
        }catch (Exception e){
            this.createAccountView.showError(e.getMessage());
        }
    }

    @Override
    public void onError(RetrofitError retrofitError) {
        this.createAccountView.showError(retrofitError.getMessage());
    }
}
