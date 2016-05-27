package com.michaelfotiadis.demorecyclerview.core.data.api;

import com.michaelfotiadis.demorecyclerview.core.models.album.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 *
 */
public interface PhotoApi {
    @Headers({
            "Accept: application/json",
    })

    @GET("photos")
    Call<List<Album>> getPhotos(@Query("_limit") String limit);

}
