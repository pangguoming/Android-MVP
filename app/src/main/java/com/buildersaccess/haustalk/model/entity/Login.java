package com.buildersaccess.haustalk.model.entity;

import java.util.List;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Login {
    private boolean activeyn ;
    private String message ;
    private String token ;
    private String tokensecret ;
    private String serverdate ;
    private String found ;
    private List<cAddressDat> cAddress ;
    private String username ;
    private List<ba_VendorsDat> vendors ;
    private String level ;
    private String adminyn ;

    public boolean isActiveyn() {
        return activeyn;
    }

    public void setActiveyn(boolean activeyn) {
        this.activeyn = activeyn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokensecret() {
        return tokensecret;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }

    public String getServerdate() {
        return serverdate;
    }

    public void setServerdate(String serverdate) {
        this.serverdate = serverdate;
    }

    public String getFound() {
        return found;
    }

    public void setFound(String found) {
        this.found = found;
    }

    public List<cAddressDat> getcAddress() {
        return cAddress;
    }

    public void setcAddress(List<cAddressDat> cAddress) {
        this.cAddress = cAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ba_VendorsDat> getVendors() {
        return vendors;
    }

    public void setVendors(List<ba_VendorsDat> vendors) {
        this.vendors = vendors;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAdminyn() {
        return adminyn;
    }

    public void setAdminyn(String adminyn) {
        this.adminyn = adminyn;
    }

    public static class ba_VendorsDat
    {
        private String idvendor ;
        private String nvendor ;

        public String getIdvendor() {
            return idvendor;
        }

        public void setIdvendor(String idvendor) {
            this.idvendor = idvendor;
        }

        public String getNvendor() {
            return nvendor;
        }

        public void setNvendor(String nvendor) {
            this.nvendor = nvendor;
        }
    }

    public static class cAddressDat
    {
        private String idcia ;
        private String idproject ;
        private String address ;
        private String idcity ;
        private String namecity ;
        private String closed ;
        private String ownername  ;
        private String verified ;
        private String besttime ;

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
