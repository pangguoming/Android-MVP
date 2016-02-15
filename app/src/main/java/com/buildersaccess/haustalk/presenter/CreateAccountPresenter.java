package com.buildersaccess.haustalk.presenter;

import com.buildersaccess.haustalk.model.entity.Req_login;
import com.buildersaccess.haustalk.model.entity.Req_step1;
import com.buildersaccess.haustalk.model.entity.Req_step2;

/**
 * Created by pangg_000 on 11/7/2015.
 */
public interface CreateAccountPresenter {
    void step1(Req_step1 req_step1);
    void step2(Req_step2 req_step2);
}
