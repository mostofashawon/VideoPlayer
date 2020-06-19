package com.example.videoplayer.viewmodel;

import com.example.videoplayer.model.GET;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CustomViewModel extends ViewModel {

    private Repository repository;
    private MutableLiveData<List<GET>> mutableLiveData;

    public MutableLiveData<List<GET>> getPost(){

          repository = new Repository();

          mutableLiveData = repository.getPost();

          return mutableLiveData;

    }

}
