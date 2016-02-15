package com.buildersaccess.haustalk.model.api;

import com.buildersaccess.haustalk.model.entity.Ba_homepm;
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
import com.buildersaccess.haustalk.model.entity.Homevendor;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Query;

public interface REST_API {

    @Headers({
            "Content-type: application/json"
    })


    @POST("/login.json")
    public void login(@Body Req_login req_login, Callback<Login> response); //Callback<Response> response

    @POST("/ba_homepm.json")
    public void ba_homepm(@Body Req_ba_homepm req_ba_homepm, Callback<Ba_homepm> response);

    @POST("/forgotpassword.json")
    public void forgotpassword(@Body Req_forgotpassword req_forgotpassword, Callback<Forgotpassword> response);

    @POST("/step1.json")
    public void step1(@Body Req_step1 req_step1, Callback<Step1> response);

    @POST("/step2.json")
    public void step2(@Body Req_step2 req_step2, Callback<Login> response);

    @POST("/ba_searchticketpm.json")
    public void ba_searchticketpm(@Body Req_ba_searchticketpm req_ba_searchticketpm, Callback<Homevendor> response);

    @POST("/ba_ticketpm.json")
    public void ba_ticketpm(@Body Req_ba_ticketpm req_ba_ticketpm, Callback<Ba_ticketpm> response);

    @GET("/pmphoto")
    public void pmphoto(@Query("email") String email, Callback<Response> callback);

    @GET("/vendorphoto")
    public void vendorphoto(@Query("email") String email, Callback<Response> callback);

    @POST("/ba_openticketpm.json")
    public void ba_openticketpm(@Body Req_ba_openticketpm req_ba_openticketpm, Callback<Homevendor> response);

    @POST("/ba_holdticketpm.json")
    public void ba_holdticketpm(@Body Req_ba_openticketpm req_ba_openticketpm, Callback<Homevendor> response);

    @POST("/ba_surveyticketpm.json")
    public void ba_surveyticketpm(@Body Req_ba_openticketpm req_ba_openticketpm, Callback<Homevendor> response);

    @POST("/ba_recivedsurveypm.json")
    public void ba_recivedsurveypm(@Body Req_ba_openticketpm req_ba_openticketpm, Callback<Homevendor> response);
}
