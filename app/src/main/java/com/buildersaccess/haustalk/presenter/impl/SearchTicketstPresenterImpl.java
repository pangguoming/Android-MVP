package com.buildersaccess.haustalk.presenter.impl;

import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.model.dao.Model;
import com.buildersaccess.haustalk.model.dao.impl.ModelImpl;
import com.buildersaccess.haustalk.model.entity.Homevendor;
import com.buildersaccess.haustalk.model.entity.Login;
import com.buildersaccess.haustalk.model.entity.Req_ba_searchticketpm;
import com.buildersaccess.haustalk.presenter.OnLoginListener;
import com.buildersaccess.haustalk.presenter.OnSearchTicketsListener;
import com.buildersaccess.haustalk.presenter.SearchTicketsPresenter;
import com.buildersaccess.haustalk.ui.view.ShowTicketsView;

import retrofit.RetrofitError;

/**
 * Created by pangg_000 on 11/7/2015.
 */
public class SearchTicketstPresenterImpl implements SearchTicketsPresenter,OnSearchTicketsListener,OnLoginListener {
    private Model model;
    private ShowTicketsView showTicketsView;
    private  Req_ba_searchticketpm req_ba_searchticketpm;
    public SearchTicketstPresenterImpl(ShowTicketsView showTicketsView) {
        this.showTicketsView = showTicketsView;
        this.model=new ModelImpl();
    }

    @Override
    public void searchTickets(Req_ba_searchticketpm req_ba_searchticketpm) {
        this.req_ba_searchticketpm=req_ba_searchticketpm;
        this.model.ba_searchticketpm(req_ba_searchticketpm,this);
    }
    @Override
    public void onBa_searchticketpmSuccess(Homevendor result) {
        try{
            if(result.getValidtoken().equals("1")) {
                this.showTicketsView.showResult(result);
            }else{
                this.model.login(HaustalkApplication.getReq_login(),this);
            }
        }catch (Exception e){
            this.showTicketsView.showError(e.getMessage());
        }
    }

    @Override
    public void onLoginSuccess(Login result) {
        try{
            HaustalkApplication.setLogin(result);
            this.req_ba_searchticketpm.setToken(result.getToken());
            this.req_ba_searchticketpm.setTokensecret(result.getTokensecret());
            searchTickets(this.req_ba_searchticketpm);
        }catch (Exception e){
            this.showTicketsView.showError(e.getMessage());
        }
    }

    @Override
    public void onError(RetrofitError retrofitError) {
        this.showTicketsView.showError(retrofitError.getMessage());
    }
}
