package com.buildersaccess.haustalk.presenter.impl;

import com.buildersaccess.haustalk.app.HaustalkApplication;
import com.buildersaccess.haustalk.model.dao.Model;
import com.buildersaccess.haustalk.model.dao.impl.ModelImpl;
import com.buildersaccess.haustalk.model.entity.Ba_homepm;
import com.buildersaccess.haustalk.model.entity.Login;
import com.buildersaccess.haustalk.model.entity.Req_ba_homepm;
import com.buildersaccess.haustalk.presenter.OnLoginListener;
import com.buildersaccess.haustalk.presenter.PmhomePresenter;
import com.buildersaccess.haustalk.presenter.OnPMhomeViewListener;
import com.buildersaccess.haustalk.ui.view.PmhomeView;

import retrofit.RetrofitError;

/**
 * Created by pangg_000 on 11/7/2015.
 */
public class PMhomeViewPresenterImpl implements PmhomePresenter,OnPMhomeViewListener ,OnLoginListener {
    private Model model;
    private PmhomeView pMhomeView;

    public PMhomeViewPresenterImpl(PmhomeView pMhomeView) {
        this.pMhomeView = pMhomeView;
        this.model=new ModelImpl();
    }

    @Override
    public void ba_homepm () {
        Req_ba_homepm req_ba_homepm=new Req_ba_homepm();
        req_ba_homepm.setToken(HaustalkApplication.getLogin().getToken());
        req_ba_homepm.setTokensecret(HaustalkApplication.getLogin().getTokensecret());
        model.ba_homepm(req_ba_homepm,this);
    }

    @Override
    public void onBa_homepmSuccess(Ba_homepm result) {
        try{
            if(result.getValidtoken().equals("1")) {
                this.pMhomeView.showMyticket(result.getProjects());
            }else{
                this.model.login(HaustalkApplication.getReq_login(),this);
            }
        }catch (Exception e){
            this.pMhomeView.showError(e.getMessage());
        }
    }

    @Override
    public void onLoginSuccess(Login result) {
        try{
            HaustalkApplication.setLogin(result);
            this.ba_homepm();
        }catch (Exception e){
            this.pMhomeView.showError(e.getMessage());
        }
    }

    @Override
    public void onError(RetrofitError retrofitError) {
        this.pMhomeView.showError(retrofitError.getMessage());
    }

}
