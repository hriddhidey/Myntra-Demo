package com.example.a300006812.myntrademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a300006812.myntrademo.model.SearchProduct;
import com.example.a300006812.myntrademo.model.SearchResults;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListScreen extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SearchResults searchResults;
    private List<SearchProduct> searchProductList = new ArrayList<>();
    private String query;
    private ProductListAdapter mProductListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_screen);

        Intent intent = getIntent();
        query = intent.getStringExtra("QUERY");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_list_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mProductListAdapter = new ProductListAdapter(searchProductList);
        recyclerView.setAdapter(mProductListAdapter);


        fetchNetworkData();

    }

    private void fetchNetworkData() {
        Call<JsonObject> searchServiceCall =
                ( (MySearchApplication) getApplication())
                        .getSearchApi()
                        .getSearchResponse(query);

        searchServiceCall.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Gson gson = new GsonBuilder().create();
                JsonObject jsonObject = response.body()
                        .getAsJsonObject("data");

                searchResults = gson.fromJson
                        (jsonObject.getAsJsonObject("results")
                                , SearchResults.class);

                searchProductList.clear();
                searchProductList.addAll(searchResults.searchProductsList);
                //mProductListAdapter.addData(searchProductList);
                mProductListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

    }

}


