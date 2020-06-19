package com.example.videoplayer.viewmodel;

import com.example.videoplayer.model.GET;
import com.example.videoplayer.network.Client;
import com.example.videoplayer.network.RetrofitApiClient;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

   public MutableLiveData<List<GET>> getPost(){

       final MutableLiveData<List<GET>> mutableLiveData = new MutableLiveData<>();

       Client client = RetrofitApiClient.getRetrofit().create(Client.class);

       Call<List<GET>> call = client.getPost();
       call.enqueue(new Callback<List<GET>>() {
           @Override
           public void onResponse(Call<List<GET>> call, Response<List<GET>> response) {

               if (response.isSuccessful()) {

                   mutableLiveData.setValue(response.body());
               }
           }

           @Override
           public void onFailure(Call<List<GET>> call, Throwable t) {

           }
       });

       return  mutableLiveData;

   }



}
