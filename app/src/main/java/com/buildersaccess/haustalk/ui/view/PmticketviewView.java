package com.buildersaccess.haustalk.ui.view;

import com.buildersaccess.haustalk.model.entity.Ba_ticketpm;
import com.buildersaccess.haustalk.model.entity.HomevendorDat;

import java.util.List;

/**
 * Created by pangg_000 on 1/23/2016.
 */
public interface PmticketviewView {
    void showPmticket(Ba_ticketpm ba_ticketpm);
    void showError(String error);
}
