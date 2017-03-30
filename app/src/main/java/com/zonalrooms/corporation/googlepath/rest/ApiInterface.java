package com.zonalrooms.corporation.googlepath.rest;


import com.zonalrooms.corporation.googlepath.SignupActivity;
import com.zonalrooms.corporation.googlepath.pojo.Result;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/*
*
 * Created by DELL on 3/28/2017.
*/


public interface ApiInterface {
    @POST("bc/create-account.php")
    Call<Result> updateUser(@Body SignupActivity.PutDetails put);
}
