package com.buildersaccess.haustalk.utility.volley;

import org.json.JSONObject;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.ClientError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

public class JSONObjectRequest {
    private RequestQueue mVolleyQueue;
    private JsonObjectRequest jsonObjRequest;
    public JSONObjectRequest() {
        mVolleyQueue = MyNetwork.getRequestQueue();
    }

    public void requestAgent(String url, JSONObject params, int method) {
        jsonObjRequest = new JsonObjectRequest(method, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("TAG", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle your error types accordingly.For Timeout & No connection error, you can show 'retry' button.
                // For AuthFailure, you can re login with user credentials.
                // For ClientError, 400 & 401, Errors happening on client side when sending api request.
                // In this case you can check how client is forming the api and debug accordingly.
                // For ServerError 5xx, you can do retry or handle accordingly.
                if (error instanceof NetworkError) {
                } else if (error instanceof ClientError) {
                } else if (error instanceof ServerError) {
                } else if (error instanceof AuthFailureError) {
                } else if (error instanceof ParseError) {
                } else if (error instanceof NoConnectionError) {
                } else if (error instanceof TimeoutError) {
                }
                Log.e("TAG", error.toString());
            }
        });

        //Set a retry policy in case of SocketTimeout & ConnectionTimeout Exceptions. Volley does retry for you if you have specified the policy.
        jsonObjRequest.setRetryPolicy(new DefaultRetryPolicy(MyNetwork.getDefaultTimeout(), DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        jsonObjRequest.setTag(this);
        mVolleyQueue.add(jsonObjRequest);
    }

    public void requestAgent(String url, JSONObject params, int method, final Response.Listener<JSONObject> OKlistener) {
        jsonObjRequest = new JsonObjectRequest(method, url, params, OKlistener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle your error types accordingly.For Timeout & No connection error, you can show 'retry' button.
                // For AuthFailure, you can re login with user credentials.
                // For ClientError, 400 & 401, Errors happening on client side when sending api request.
                // In this case you can check how client is forming the api and debug accordingly.
                // For ServerError 5xx, you can do retry or handle accordingly.
                if (error instanceof NetworkError) {
                } else if (error instanceof ClientError) {
                } else if (error instanceof ServerError) {
                } else if (error instanceof AuthFailureError) {
                } else if (error instanceof ParseError) {
                } else if (error instanceof NoConnectionError) {
                } else if (error instanceof TimeoutError) {
                }
                Log.e("TAG", error.toString());
            }
        });

        //Set a retry policy in case of SocketTimeout & ConnectionTimeout Exceptions. Volley does retry for you if you have specified the policy.
        jsonObjRequest.setRetryPolicy(new DefaultRetryPolicy(MyNetwork.getDefaultTimeout(), DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        jsonObjRequest.setTag(this);
        mVolleyQueue.add(jsonObjRequest);
    }

    public void requestAgent(String url, JSONObject params, int method, Response.Listener<JSONObject> OKlistener, Response.ErrorListener errorListener) {
        jsonObjRequest = new JsonObjectRequest(method, url, params, OKlistener, errorListener);
        //Set a retry policy in case of SocketTimeout & ConnectionTimeout Exceptions. Volley does retry for you if you have specified the policy.
        jsonObjRequest.setRetryPolicy(new DefaultRetryPolicy(MyNetwork.getDefaultTimeout(), DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        jsonObjRequest.setTag(this);
        mVolleyQueue.add(jsonObjRequest);
    }
    public void requestAgent(String url, JSONObject params, int method, Response.Listener<JSONObject> OKlistener, Response.ErrorListener errorListener,int timeout) {
        jsonObjRequest = new JsonObjectRequest(method, url, params, OKlistener, errorListener);
        //Set a retry policy in case of SocketTimeout & ConnectionTimeout Exceptions. Volley does retry for you if you have specified the policy.
        jsonObjRequest.setRetryPolicy(new DefaultRetryPolicy(timeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        jsonObjRequest.setTag(this);
        mVolleyQueue.add(jsonObjRequest);
    }
    public void cancel(){
        mVolleyQueue.cancelAll(this);
    }
}

