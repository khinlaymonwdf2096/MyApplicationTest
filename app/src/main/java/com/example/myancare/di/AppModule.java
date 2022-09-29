package com.example.myancare.di;

import com.example.myancare.network.RetroServiceInterface;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    String baseurl="https://api.punkapi.com/v2/";

    @Singleton
    @Provides
    public RetroServiceInterface getRetroServiceInterface(Retrofit retrofit){
        return retrofit.create(RetroServiceInterface.class);
    }

    @Singleton
    @Provides
    public Retrofit getRetroInstande(){
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .readTimeout(68*2, TimeUnit.SECONDS)
                .connectTimeout(68*2,TimeUnit.SECONDS)
                .writeTimeout(68*2,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        return new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }
}
