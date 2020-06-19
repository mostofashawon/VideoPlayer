package com.example.videoplayer.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClient {

    private static final String BASE_URL="http://wap.gaanbajna.net/";
    private static Retrofit retrofit;


    private RetrofitApiClient(){

    }

    public static synchronized Retrofit getRetrofit (){

        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }

}
