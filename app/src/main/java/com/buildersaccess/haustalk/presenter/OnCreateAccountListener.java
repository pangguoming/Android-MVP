package com.buildersaccess.haustalk.presenter;

import com.buildersaccess.haustalk.model.entity.Login;
import com.buildersaccess.haustalk.model.entity.Step1;

import retrofit.RetrofitError;

/**
 * Created by pangg_000 on 11/7/2015.
 */
public interface OnCreateAccountListener {

    void onCreateAccountSuccess(Step1 result);
    void onCreateAccountS2Success(Login result);
    /**
     * 失败时回调，简单处理，没做什么
     */
    void  onError(RetrofitError retrofitError);
}
