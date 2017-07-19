package com.example.a300006812.myntrademo;

import android.app.Application;

import com.example.a300006812.myntrademo.api.SearchApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 300006812 on 7/19/17.
 */

public class MySearchApplication extends Application {
    
    private static final String BASE_URI = "http://developer.myntra.com/";
    private Retrofit mRetrofit;
    private SearchApi mSearchApi;

    @Override
    public void onCreate() {
        super.onCreate();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mSearchApi = mRetrofit.create(SearchApi.class);

    }

    public SearchApi getSearchApi() {
        return mSearchApi;
    }
}
