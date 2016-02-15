package com.buildersaccess.haustalk.ui.view;

import com.buildersaccess.haustalk.model.entity.Forgotpassword;

/**
 * Created by pangg_000 on 1/23/2016.
 */
public interface ForgotPassWordView {
    void showResult(Forgotpassword result);
    void showError(String error);
}
