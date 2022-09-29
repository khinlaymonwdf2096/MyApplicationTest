package com.example.myancare.network;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.myancare.model.ItemInfo;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RetroRepostiory {
    private RetroServiceInterface retroServiceInterface;
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    public RetroRepostiory(RetroServiceInterface retroServiceInterface) {
        this.retroServiceInterface = retroServiceInterface;
    }

    public void   getLiveData(MutableLiveData<List<ItemInfo>> liveData){


           compositeDisposable.add(retroServiceInterface.getData(1,20)
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribe(new Consumer<List<ItemInfo>>() {
                       @Override
                       public void accept(List<ItemInfo> itemInfos) throws Throwable {
                            liveData.setValue(itemInfos);
                       }
                   }, new Consumer<Throwable>() {
                       @Override
                       public void accept(Throwable throwable) throws Throwable {
                           liveData.setValue(null);
                       }
                   })
                  );



    }
}
