package com.lifeapps.tickerapi.network;

import com.lifeapps.myhealth.model.KoinexResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by varunbehl on 07/03/17.
 */

interface DataInterface {

//    @Headers("Content-type: application/json")
//    @POST("user/")
//    public Observable saveUser(@Body User text);
//
//    @POST("SpringRest/User/")
//    Call<User> createUser(@Body User user);
//
//    @GET("SpringRest/User/")
//    @GET("SpringRest/User/")
//    Observable<List<User>> getUsers();

    @GET("ticker")
    Observable<KoinexResponse> getKoinexResponse();
}
