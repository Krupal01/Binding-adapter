package com.example.bindingadapter.network;

import com.example.bindingadapter.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    public RetroService getAlbumService(){
        return getRetroInstance().create(RetroService.class);
    }

    public Retrofit getRetroInstance(){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }
}
