package com.buildersaccess.haustalk.presenter.impl;

import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.model.dao.Model;
import com.buildersaccess.haustalk.model.dao.impl.ModelImpl;
import com.buildersaccess.haustalk.model.entity.Homevendor;
import com.buildersaccess.haustalk.model.entity.Login;
import com.buildersaccess.haustalk.model.entity.Req_ba_openticketpm;
import com.buildersaccess.haustalk.presenter.OnLoginListener;
import com.buildersaccess.haustalk.presenter.OnOpenSurveyListener;
import com.buildersaccess.haustalk.presenter.OpenSurveyPresenter;
import com.buildersaccess.haustalk.ui.view.ShowTicketsView;

import retrofit.RetrofitError;

/**
 * Created by pangg_000 on 11/7/2015.
 */
public class OpenSurveyPresenterImpl implements OpenSurveyPresenter,OnOpenSurveyListener,OnLoginListener {
    private Model model;
    private ShowTicketsView showTicketsView;
    private Req_ba_openticketpm req_ba_openticketpm;

    public OpenSurveyPresenterImpl(ShowTicketsView showTicketsView) {
        this.showTicketsView = showTicketsView;
        this.model=new ModelImpl();
    }

    @Override
    public void ba_surveyticketpm(Req_ba_openticketpm req_ba_openticketpm) {
        this.req_ba_openticketpm=req_ba_openticketpm;
        this.model.ba_surveyticketpm(req_ba_openticketpm, this);
    }

    @Override
    public void onBa_surveyticketpmSuccess(Homevendor result) {
        try {
            if (result.getValidtoken().equals("1")) {
                this.showTicketsView.showResult(result);
            } else {
                this.model.login(HaustalkApplication.getReq_login(), this);
            }
        }catch (Exception e){
            this.showTicketsView.showError(e.getMessage());
        }
    }

    @Override
    public void onLoginSuccess(Login result) {
        try{
            HaustalkApplication.setLogin(result);
            this.req_ba_openticketpm.setToken(result.getToken());
            this.req_ba_openticketpm.setTokensecret(result.getTokensecret());
            ba_surveyticketpm(this.req_ba_openticketpm);
        }catch (Exception e){
            this.showTicketsView.showError(e.getMessage());
        }
    }

    @Override
    public void onError(RetrofitError retrofitError) {
        this.showTicketsView.showError(retrofitError.getMessage());
    }

}
