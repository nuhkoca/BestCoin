package com.mobilemovement.bestcoin.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mobilemovement.bestcoin.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nuhkoca on 9.12.2017.
 */

/**
 *  A class to build Retrofit {@link RetrofitInterceptor
 */

public class RetrofitInterceptor {
    public static Retrofit build() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .serializeNulls()
                .create();

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}