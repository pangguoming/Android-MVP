package com.buildersaccess.haustalk.model.dao.impl;

import com.buildersaccess.haustalk.model.api.REST_API;
import com.buildersaccess.haustalk.model.dao.Model;
import com.buildersaccess.haustalk.model.entity.Ba_homepm;
import com.buildersaccess.haustalk.model.entity.Homevendor;
import com.buildersaccess.haustalk.model.entity.Ba_ticketpm;
import com.buildersaccess.haustalk.model.entity.Forgotpassword;
import com.buildersaccess.haustalk.model.entity.Login;
import com.buildersaccess.haustalk.model.entity.Req_ba_homepm;
import com.buildersaccess.haustalk.model.entity.Req_ba_openticketpm;
import com.buildersaccess.haustalk.model.entity.Req_ba_searchticketpm;
import com.buildersaccess.haustalk.model.entity.Req_ba_ticketpm;
import com.buildersaccess.haustalk.model.entity.Req_forgotpassword;
import com.buildersaccess.haustalk.model.entity.Req_login;
import com.buildersaccess.haustalk.model.entity.Req_step1;
import com.buildersaccess.haustalk.model.entity.Req_step2;
import com.buildersaccess.haustalk.model.entity.Step1;
import com.buildersaccess.haustalk.presenter.OnCreateAccountListener;
import com.buildersaccess.haustalk.presenter.OnForgotPasswordListener;
import com.buildersaccess.haustalk.presenter.OnLoginListener;
import com.buildersaccess.haustalk.presenter.OnOpenSurveyListener;
import com.buildersaccess.haustalk.presenter.OnSurveyReceivedListener;
import com.buildersaccess.haustalk.presenter.OnTicketsListener;
import com.buildersaccess.haustalk.presenter.OnPMhomeViewListener;
import com.buildersaccess.haustalk.presenter.OnPmticketviewListener;
import com.buildersaccess.haustalk.presenter.OnSearchTicketsListener;
import com.buildersaccess.haustalk.utility.RetrofitApiAdapter;

import retrofit.Callback;
import retrofit.RetrofitError;

/**
 * Created by pangg_000 on 11/7/2015.
 */
public class ModelImpl implements Model {

    REST_API rest_api;

    public ModelImpl() {
        this.rest_api = RetrofitApiAdapter.getInstance().create(REST_API.class);
    }


    @Override
    public void login(Req_login req_login, final OnLoginListener listener) {
        rest_api.login( req_login, new Callback<Login>() {
            @Override
            public void success(Login login, retrofit.client.Response response) {
              /*  String jsonstr=new String(((TypedByteArray) response.getBody()).getBytes());
                Login login= new Gson().fromJson(jsonstr, Login.class);*/
                listener.onLoginSuccess(login);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                retrofitError.printStackTrace();
                listener.onError(retrofitError);
            }
        });
    }

    @Override
    public void ba_homepm(final Req_ba_homepm req_ba_homepm,final OnPMhomeViewListener listener) {
        rest_api.ba_homepm(req_ba_homepm, new Callback<Ba_homepm>() {
            @Override
            public void success(Ba_homepm ba_homepm, retrofit.client.Response response) {
                listener.onBa_homepmSuccess(ba_homepm);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                retrofitError.printStackTrace();
                listener.onError(retrofitError);
            }
        });
    }

    @Override
    public void forgotpassword(Req_forgotpassword req_forgotpassword,final OnForgotPasswordListener listener) {
        rest_api.forgotpassword(req_forgotpassword, new Callback<Forgotpassword>() {
            @Override
            public void success(Forgotpassword forgotpassword, retrofit.client.Response response) {
                listener.OnForgotPasswordSuccess(forgotpassword);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                retrofitError.printStackTrace();
                listener.onError(retrofitError);
            }
        });
    }

    @Override
    public void step1(Req_step1 req_step1, final OnCreateAccountListener listener) {

        rest_api.step1(req_step1, new Callback<Step1>() {
            @Override
            public void success(Step1 step1, retrofit.client.Response response) {
                listener.onCreateAccountSuccess(step1);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                retrofitError.printStackTrace();
                listener.onError(retrofitError);
            }
        });
    }

    @Override
    public void step2(Req_step2 req_step2,final OnCreateAccountListener listener) {
        rest_api.step2(req_step2, new Callback<Login>() {
            @Override
            public void success(Login login, retrofit.client.Response response) {
                listener.onCreateAccountS2Success(login);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                retrofitError.printStackTrace();
                listener.onError(retrofitError);
            }
        });
    }

    @Override
    public void ba_searchticketpm(Req_ba_searchticketpm req_ba_searchticketpm, final OnSearchTicketsListener listener) {
        rest_api.ba_searchticketpm(req_ba_searchticketpm, new Callback<Homevendor>() {
            @Override
            public void success(Homevendor ba_searchticketpm, retrofit.client.Response response) {
                listener.onBa_searchticketpmSuccess(ba_searchticketpm);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                retrofitError.printStackTrace();
                listener.onError(retrofitError);
            }
        });
    }

    @Override
    public void ba_ticketpm(Req_ba_ticketpm req_ba_ticketpm, final OnPmticketviewListener listener) {
        rest_api.ba_ticketpm(req_ba_ticketpm, new Callback<Ba_ticketpm>() {
            @Override
            public void success(Ba_ticketpm ba_ticketpm, retrofit.client.Response response) {
                listener.onBa_ticketpmSuccess(ba_ticketpm);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                retrofitError.printStackTrace();
                listener.onError(retrofitError);
            }
        });
    }

    @Override
    public void ba_openticketpm(Req_ba_openticketpm req_ba_openticketpm,final OnTicketsListener listener) {
        rest_api.ba_openticketpm(req_ba_openticketpm, new Callback<Homevendor>() {
            @Override
            public void success(Homevendor homevendor, retrofit.client.Response response) {
                listener.onBa_searchticketpmSuccess(homevendor);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                retrofitError.printStackTrace();
                listener.onError(retrofitError);
            }
        });
    }

    @Override
    public void ba_holdticketpm(Req_ba_openticketpm req_ba_openticketpm,final OnTicketsListener listener) {
        rest_api.ba_holdticketpm(req_ba_openticketpm, new Callback<Homevendor>() {
            @Override
            public void success(Homevendor homevendor, retrofit.client.Response response) {
                listener.onBa_searchticketpmSuccess(homevendor);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                retrofitError.printStackTrace();
                listener.onError(retrofitError);
            }
        });
    }

    @Override
    public void ba_surveyticketpm(Req_ba_openticketpm req_ba_openticketpm,final OnOpenSurveyListener listener) {
        rest_api.ba_surveyticketpm(req_ba_openticketpm, new Callback<Homevendor>() {
            @Override
            public void success(Homevendor homevendor, retrofit.client.Response response) {
                listener.onBa_surveyticketpmSuccess(homevendor);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                retrofitError.printStackTrace();
                listener.onError(retrofitError);
            }
        });
    }

    @Override
    public void ba_recivedsurveypm(Req_ba_openticketpm req_ba_openticketpm,final OnSurveyReceivedListener listener) {
        rest_api.ba_recivedsurveypm(req_ba_openticketpm, new Callback<Homevendor>() {
            @Override
            public void success(Homevendor homevendor, retrofit.client.Response response) {
                listener.onBa_recivedsurveypmSuccess(homevendor);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                retrofitError.printStackTrace();
                listener.onError(retrofitError);
            }
        });
    }
}
