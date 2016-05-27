package com.michaelfotiadis.demorecyclerview.core.data.loaders;

import com.michaelfotiadis.demorecyclerview.core.data.loaders.callbacks.AlbumListCallback;
import com.michaelfotiadis.demorecyclerview.core.data.responses.CommonCallback;
import com.michaelfotiadis.demorecyclerview.core.data.rest.RestClient;
import com.michaelfotiadis.demorecyclerview.core.models.album.Album;
import com.michaelfotiadis.demorecyclerview.core.utils.CoreLog;

import java.util.List;

public class LoaderNetwork extends Loader {
    private final NetworkRequestForwarder mRequestForwarder;

    /*package*/ LoaderNetwork(final RestClient restClient) {
        // initialise the rest client with cache
        this.mRequestForwarder = new NetworkRequestForwarder(restClient);
    }

    @Override
    protected void getPhotos(final Integer limit,
                             final CommonCallback<List<Album>> masterCallback) {
        CoreLog.d("Requesting photos with limit " + limit);
        mRequestForwarder.forwardGetPhotos(limit, new AlbumListCallback(masterCallback));
    }

}