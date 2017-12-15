package com.lifeapps.tickerapi.network;

import com.lifeapps.myhealth.model.KoinexResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by varunbehl on 07/03/17.
 */
public class RetrofitManager {

    private static DataInterface dataInterface = null;
    private static RetrofitManager retrofitManager;

    private RetrofitManager() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(5, TimeUnit.SECONDS);

//            if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);
//            }

        OkHttpClient client = builder.build();

//        String API_BASE_URL = "http://varunbehl.localhost.run/";
        String API_BASE_URL = "https://koinex.in/api/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        dataInterface = retrofit.create(DataInterface.class);

    }

    public static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            retrofitManager = new RetrofitManager();
        }
        return retrofitManager;
    }


    public Observable<KoinexResponse> getKoinexResponse() {
        return dataInterface.getKoinexResponse();
    }


}


