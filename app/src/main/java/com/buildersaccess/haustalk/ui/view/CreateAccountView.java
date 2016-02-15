package com.buildersaccess.haustalk.ui.view;

import com.buildersaccess.haustalk.model.entity.Ba_homepm;
import com.buildersaccess.haustalk.model.entity.Step1;

import java.util.List;

/**
 * Created by pangg_000 on 1/23/2016.
 */
public interface CreateAccountView {
    void gotoStep2(Step1 result);
    void gotoSelectHome(Step1 result);
    void gotoFinish();
    void showError(String error);
}
