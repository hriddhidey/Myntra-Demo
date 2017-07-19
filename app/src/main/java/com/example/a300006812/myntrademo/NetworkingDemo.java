package com.example.a300006812.myntrademo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a300006812.myntrademo.model.SearchResults;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkingDemo extends AppCompatActivity {

    private Button mBtNetwork;
    private TextView mTvNetworkResult;
    private ImageView mIvProductImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networking_demo);

        mBtNetwork = (Button) findViewById(R.id.bt_networking);
        mTvNetworkResult = (TextView) findViewById(R.id.tv_networking_result);
        mIvProductImage = (ImageView) findViewById(R.id.iv_product_image);

        mBtNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                GetNetworkResponse getNetworkResponse = new GetNetworkResponse();
//                getNetworkResponse.execute();
                fetchNetworkData();

            }
        });
    }

    private void fetchNetworkData() {
        Call<JsonObject> searchServiceCall =
                ( (MySearchApplication) getApplication())
                .getSearchApi()
                .getSearchResponse("nike");

        searchServiceCall.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Gson gson = new GsonBuilder().create();
                JsonObject jsonObject = response.body()
                        .getAsJsonObject("data");

                SearchResults searchResults = gson.fromJson
                        (jsonObject.getAsJsonObject("results")
                        , SearchResults.class);

                Glide.with(getApplicationContext())
                        .load(searchResults.searchProductsList.get(0).searchImage)
                        .into(mIvProductImage);

                mTvNetworkResult.setText(searchResults.searchProductsList.get(0).styleName);

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

    }

    class GetNetworkResponse extends AsyncTask<Void, Void, String>{

        HttpURLConnection urlConnection;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {
            StringBuilder result = new StringBuilder();

            try {

                URL searchUrl = new URL("http://developer.myntra.com/search/data/nike");
                urlConnection = (HttpURLConnection) searchUrl.openConnection();
                InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while( (line=bufferedReader.readLine()) != null){
                    result.append(line);
                }

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                urlConnection.disconnect();
            }

            return result.toString();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mTvNetworkResult.setText(s);
        }
    }
}
