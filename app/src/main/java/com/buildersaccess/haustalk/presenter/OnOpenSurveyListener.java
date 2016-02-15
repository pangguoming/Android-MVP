package com.buildersaccess.haustalk.presenter;

import com.buildersaccess.haustalk.model.entity.Ba_ticketpm;
import com.buildersaccess.haustalk.model.entity.Homevendor;

import retrofit.RetrofitError;

/**
 * Created by pangg_000 on 2/2/2016.
 */
public interface OnOpenSurveyListener {
    void onBa_surveyticketpmSuccess(Homevendor result);
    /**
     * 失败时回调，简单处理，没做什么
     */
    void  onError(RetrofitError retrofitError);
}
