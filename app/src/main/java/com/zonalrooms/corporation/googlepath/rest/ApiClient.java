package com.zonalrooms.corporation.googlepath.rest;

import retrofit2.Retrofit;

/**
 * Created by DELL on 3/28/2017.
 */

public class ApiClient {

    public static final String baseurl = "http://192.168.0.108:90/";
    private static Retrofit retrofit = null;
    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(baseurl).build();
        }
        return retrofit;
    }
}
