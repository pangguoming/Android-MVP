package com.buildersaccess.haustalk.presenter;

import com.buildersaccess.haustalk.model.entity.Req_ba_openticketpm;
import com.buildersaccess.haustalk.model.entity.Req_ba_searchticketpm;

/**
 * Created by pangg_000 on 11/7/2015.
 */
public interface TicketsPresenter {
    void ba_openticketpm(Req_ba_openticketpm req_ba_openticketpm);
    void ba_holdticketpm(Req_ba_openticketpm req_ba_openticketpm);
}
