package com.buildersaccess.haustalk.ui.view;

import com.buildersaccess.haustalk.model.entity.Ba_homepm;
import com.buildersaccess.haustalk.model.entity.HomevendorDat;

import java.util.List;

/**
 * Created by pangg_000 on 1/23/2016.
 */
public interface PmhomeView {
    void showMyticket(List<HomevendorDat> list);
    void showError(String error);
}
