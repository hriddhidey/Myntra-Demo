package com.example.a300006812.myntrademo.api;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by 300006812 on 7/19/17.
 */

public interface SearchApi {

    @GET("search/data/{query}")
    Call<JsonObject> getSearchResponse(@Path("query") String query);

}
