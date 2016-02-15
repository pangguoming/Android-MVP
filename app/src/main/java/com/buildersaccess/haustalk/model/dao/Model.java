package com.buildersaccess.haustalk.model.dao;

import com.buildersaccess.haustalk.model.entity.Req_ba_homepm;
import com.buildersaccess.haustalk.model.entity.Req_ba_openticketpm;
import com.buildersaccess.haustalk.model.entity.Req_ba_searchticketpm;
import com.buildersaccess.haustalk.model.entity.Req_ba_ticketpm;
import com.buildersaccess.haustalk.model.entity.Req_forgotpassword;
import com.buildersaccess.haustalk.model.entity.Req_login;
import com.buildersaccess.haustalk.model.entity.Req_step1;
import com.buildersaccess.haustalk.model.entity.Req_step2;
import com.buildersaccess.haustalk.presenter.OnCreateAccountListener;
import com.buildersaccess.haustalk.presenter.OnForgotPasswordListener;
import com.buildersaccess.haustalk.presenter.OnLoginListener;
import com.buildersaccess.haustalk.presenter.OnOpenSurveyListener;
import com.buildersaccess.haustalk.presenter.OnSurveyReceivedListener;
import com.buildersaccess.haustalk.presenter.OnTicketsListener;
import com.buildersaccess.haustalk.presenter.OnPMhomeViewListener;
import com.buildersaccess.haustalk.presenter.OnPmticketviewListener;
import com.buildersaccess.haustalk.presenter.OnSearchTicketsListener;

/**
 * Created by pangg_000 on 11/7/2015.
 */
public interface Model {
    void login(Req_login req_login, OnLoginListener listener);

    void ba_homepm(Req_ba_homepm req_ba_homepm, OnPMhomeViewListener listener);

    void forgotpassword(Req_forgotpassword req_forgotpassword, OnForgotPasswordListener listener);

    void step1(Req_step1 req_step1, OnCreateAccountListener listener);

    void step2(Req_step2 req_step2, OnCreateAccountListener listener);

    void ba_searchticketpm(Req_ba_searchticketpm req_ba_searchticketpm, OnSearchTicketsListener listener);

    void ba_ticketpm(Req_ba_ticketpm req_ba_ticketpm, OnPmticketviewListener listener);

    void ba_openticketpm(Req_ba_openticketpm req_ba_openticketpm, OnTicketsListener listener);

    void ba_holdticketpm(Req_ba_openticketpm req_ba_openticketpm, OnTicketsListener listener);

    void ba_surveyticketpm(Req_ba_openticketpm req_ba_openticketpm, OnOpenSurveyListener listener);

    void ba_recivedsurveypm(Req_ba_openticketpm req_ba_openticketpm, OnSurveyReceivedListener listener);
}

