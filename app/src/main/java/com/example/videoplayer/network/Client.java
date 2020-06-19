package com.example.videoplayer.network;

import com.example.videoplayer.model.GET;

import java.util.List;

import retrofit2.Call;

public interface Client {

    @retrofit2.http.GET("app/allcontent.php")
    Call<List<GET>> getPost();

}
