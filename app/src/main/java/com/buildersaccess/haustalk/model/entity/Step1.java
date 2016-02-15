package com.buildersaccess.haustalk.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by pangg_000 on 1/26/2016.
 */
public class Step1  {
    private String  message;
    private String  serverdate;
    private List<cAddressDat> cAddress;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getServerdate() {
        return serverdate;
    }

    public void setServerdate(String serverdate) {
        this.serverdate = serverdate;
    }

    public List<cAddressDat> getcAddress() {
        return cAddress;
    }

    public void setcAddress(List<cAddressDat> cAddress) {
        this.cAddress = cAddress;
    }

    public static class cAddressDat
    {
        private String  idcia;
        private String  idproject;
        private String  address;
        private String  idcity;
        private String  namecity;
        private String  closed;
        private String  ownername ;
        private String  verified;
        private String  besttime;

        public String getIdcia() {
            return idcia;
        }

        public void setIdcia(String idcia) {
            this.idcia = idcia;
        }

        public String getIdproject() {
            return idproject;
        }

        public void setIdproject(String idproject) {
            this.idproject = idproject;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getIdcity() {
            return idcity;
        }

        public void setIdcity(String idcity) {
            this.idcity = idcity;
        }

        public String getNamecity() {
            return namecity;
        }

        public void setNamecity(String namecity) {
            this.namecity = namecity;
        }

        public String getClosed() {
            return closed;
        }

        public void setClosed(String closed) {
            this.closed = closed;
        }

        public String getOwnername() {
            return ownername;
        }

        public void setOwnername(String ownername) {
            this.ownername = ownername;
        }

        public String getVerified() {
            return verified;
        }

        public void setVerified(String verified) {
            this.verified = verified;
        }

        public String getBesttime() {
            return besttime;
        }

        public void setBesttime(String besttime) {
            this.besttime = besttime;
        }
    }
}
