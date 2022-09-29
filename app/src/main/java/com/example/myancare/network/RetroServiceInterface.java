package com.example.myancare.network;

import com.example.myancare.model.ItemInfo;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroServiceInterface {


    @GET("beers")
    Observable<List<ItemInfo>> getData(@Query("page") int page, @Query("per_page") int per_page);


}
