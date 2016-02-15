package com.buildersaccess.haustalk.presenter;

import com.buildersaccess.haustalk.model.entity.Ba_homepm;
import com.buildersaccess.haustalk.model.entity.Login;

import retrofit.RetrofitError;

/**
 * Created by pangg_000 on 11/7/2015.
 */
public interface OnPMhomeViewListener {

    void onBa_homepmSuccess(Ba_homepm result);
    /**
     * 失败时回调，简单处理，没做什么
     */
    void  onError(RetrofitError retrofitError);
}
