package com.buildersaccess.haustalk.utility;


import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class RetrofitApiAdapter {

    private static RestAdapter sharedInstance = null;

    public static RestAdapter getInstance() {
        if (sharedInstance == null){
            final OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient.setReadTimeout(60, TimeUnit.SECONDS);
            okHttpClient.setConnectTimeout(60, TimeUnit.SECONDS);

            sharedInstance = new RestAdapter.Builder()
                    .setEndpoint("https://yourREST-API-Domain.com/")
                    .setClient(new OkClient(okHttpClient))
                    .build();
        }

        return sharedInstance;
    }
}
