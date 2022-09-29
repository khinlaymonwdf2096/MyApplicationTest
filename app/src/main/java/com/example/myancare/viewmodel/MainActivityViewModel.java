package com.example.myancare.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.myancare.model.ItemInfo;
import com.example.myancare.network.RetroRepostiory;
import com.example.myancare.network.RetroServiceInterface;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.core.Observable;

@HiltViewModel
public class MainActivityViewModel extends ViewModel {
    MutableLiveData<List<ItemInfo>> liveData;


    @Inject
    RetroServiceInterface retroServiceInterface;

    @Inject
    public MainActivityViewModel() {
        liveData=new MutableLiveData();
    }

    @Inject
    public MutableLiveData<List<ItemInfo>> getMutableLiveData() {
        return liveData;
    }

    public void makeapiCall(){
        RetroRepostiory retroRepostiory=new RetroRepostiory(retroServiceInterface);
        retroRepostiory.getLiveData(liveData);


    }






}
