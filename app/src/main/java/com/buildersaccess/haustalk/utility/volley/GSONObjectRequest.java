package com.buildersaccess.haustalk.utility.volley;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;

import com.buildersaccess.haustalk.utility.volley.volleytoolbox.GsonRequest;

import java.util.Map;

public class GSONObjectRequest<T> {

    private RequestQueue mVolleyQueue;
    private GsonRequest<T> gsonObjRequest;
    private String url;
    private int method;
    private Class<T> clazz;
    private Response.Listener<T> listener;
    private Response.ErrorListener errorListener;

    public GSONObjectRequest() {
        this.mVolleyQueue = MyNetwork.getRequestQueue();
    }
    public GSONObjectRequest( String url,int method){
        this.mVolleyQueue = MyNetwork.getRequestQueue();
        this.url=url;
        this.method=method;
    }
    public GSONObjectRequest( String url,int method, Class<T> clazz){
        this.mVolleyQueue = MyNetwork.getRequestQueue();
        this.url=url;
        this.method=method;
        this.clazz=clazz;
    }
    public GSONObjectRequest( String url,int method, Class<T> clazz, Response.Listener<T> listener,
                              Response.ErrorListener errorListener){
        this.mVolleyQueue = MyNetwork.getRequestQueue();
        this.url=url;
        this.method=method;
        this.clazz=clazz;
        this.listener=listener;
        this.errorListener=errorListener;
    }
    public GsonRequest<T> requestAgent(Map<String, String> params) {
        gsonObjRequest = new GsonRequest<T>(this.method, this.url, this.clazz,params, this.listener, this.errorListener);
        //Set a retry policy in case of SocketTimeout & ConnectionTimeout Exceptions. Volley does retry for you if you have specified the policy.
        gsonObjRequest.setRetryPolicy(new DefaultRetryPolicy(MyNetwork.getDefaultTimeout(), DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        gsonObjRequest.setTag(this);
        mVolleyQueue.add(gsonObjRequest);
        return gsonObjRequest;
    }
    public GsonRequest<T> requestAgent(Map<String, String> params,Response.Listener<T> listener, Response.ErrorListener errorListener) {
        gsonObjRequest = new GsonRequest<T>(this.method, this.url, this.clazz,params, listener, errorListener);
        //Set a retry policy in case of SocketTimeout & ConnectionTimeout Exceptions. Volley does retry for you if you have specified the policy.
        gsonObjRequest.setRetryPolicy(new DefaultRetryPolicy(MyNetwork.getDefaultTimeout(), DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        gsonObjRequest.setTag(this);
        mVolleyQueue.add(gsonObjRequest);
        return gsonObjRequest;
    }
    public void cancel(){
        mVolleyQueue.cancelAll(this);
    }
}
