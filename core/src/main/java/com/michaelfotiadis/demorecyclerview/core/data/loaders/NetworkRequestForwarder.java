package com.michaelfotiadis.demorecyclerview.core.data.loaders;

import com.michaelfotiadis.demorecyclerview.core.data.rest.RestClient;
import com.michaelfotiadis.demorecyclerview.core.models.album.Album;
import com.michaelfotiadis.demorecyclerview.core.utils.CoreLog;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 *
 */
/*package*/ class NetworkRequestForwarder {

    private final RestClient mRestClient;


    public NetworkRequestForwarder(final RestClient restClient) {
        this.mRestClient = restClient;
    }

    public void forwardGetPhotos(final Integer limit,
                                 final Callback<List<Album>> retrofitCallback) {

        CoreLog.d("Creating the call");
        final Call<List<Album>> call = mRestClient.getPhotoApi().getPhotos(String.valueOf(limit));
        CoreLog.d("Enqueuing callback");
        call.enqueue(retrofitCallback);
    }

}
