package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_staticmap {
    /**
     * lat : String
     * lng : String
     * zoom : String
     */

    private String lat;
    private String lng;
    private String zoom;

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void setZoom(String zoom) {
        this.zoom = zoom;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getZoom() {
        return zoom;
    }
}
