package com.example.bindingadapter.network;

import com.example.bindingadapter.model.PhotoListItem;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroService {

    @GET("photos")
    Single<List<PhotoListItem>> getPhotoList(@Query("albumId")int albumId);

}
