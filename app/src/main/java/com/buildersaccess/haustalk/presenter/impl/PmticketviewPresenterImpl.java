package com.buildersaccess.haustalk.presenter.impl;

import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.model.dao.Model;
import com.buildersaccess.haustalk.model.dao.impl.ModelImpl;
import com.buildersaccess.haustalk.model.entity.Ba_ticketpm;
import com.buildersaccess.haustalk.model.entity.Login;
import com.buildersaccess.haustalk.model.entity.Req_ba_ticketpm;
import com.buildersaccess.haustalk.presenter.OnLoginListener;
import com.buildersaccess.haustalk.presenter.OnPmticketviewListener;
import com.buildersaccess.haustalk.presenter.PmticketviewPresenter;
import com.buildersaccess.haustalk.ui.view.PmticketviewView;

import retrofit.RetrofitError;

/**
 * Created by pangg_000 on 11/7/2015.
 */
public class PmticketviewPresenterImpl implements PmticketviewPresenter,OnPmticketviewListener,OnLoginListener {
    private Model model;
    private PmticketviewView pmticketviewView;
    private Req_ba_ticketpm req_ba_ticketpm;
    public PmticketviewPresenterImpl(PmticketviewView pmticketviewView) {
        this.pmticketviewView = pmticketviewView;
        this.model=new ModelImpl();
    }

    @Override
    public void ba_ticketpm(Req_ba_ticketpm req_ba_ticketpm) {
        this.req_ba_ticketpm=req_ba_ticketpm;
        this.model.ba_ticketpm(req_ba_ticketpm,this);

    }

    @Override
    public void onBa_ticketpmSuccess(Ba_ticketpm result) {
        try{
            if(result.getValidtoken().equals("1")) {
                this.pmticketviewView.showPmticket(result);
            }else{
                this.model.login(HaustalkApplication.getReq_login(),this);
            }
        }catch (Exception e){
            this.pmticketviewView.showError(e.getMessage());
        }
    }

    @Override
    public void onLoginSuccess(Login result) {
        try{
            HaustalkApplication.setLogin(result);
            this.req_ba_ticketpm.setToken(result.getToken());
            this.req_ba_ticketpm.setTokensecret(result.getTokensecret());
            this.ba_ticketpm(this.req_ba_ticketpm);
        }catch (Exception e){
            this.pmticketviewView.showError(e.getMessage());
        }
    }


    @Override
    public void onError(RetrofitError retrofitError) {
        this.pmticketviewView.showError(retrofitError.getMessage());
    }
}
