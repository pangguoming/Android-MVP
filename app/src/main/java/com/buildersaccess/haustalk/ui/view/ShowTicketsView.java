package com.buildersaccess.haustalk.ui.view;

import com.buildersaccess.haustalk.model.entity.Homevendor;

/**
 * Created by pangg_000 on 1/23/2016.
 */
public interface ShowTicketsView {
    void showResult(Homevendor result);
    void showError(String error);
}
