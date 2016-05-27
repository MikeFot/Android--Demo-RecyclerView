package com.michaelfotiadis.demorecyclerview.core.data.loaders;

import com.michaelfotiadis.demorecyclerview.core.data.responses.CommonCallback;
import com.michaelfotiadis.demorecyclerview.core.data.rest.RestClientImpl;
import com.michaelfotiadis.demorecyclerview.core.models.album.Album;
import com.michaelfotiadis.demorecyclerview.core.utils.CoreLog;

import java.util.List;

/**
 *
 */
public class DataProvider {

    private final LoaderNetwork mNetworkLoader;

    public DataProvider() {
        mNetworkLoader = new LoaderNetwork(new RestClientImpl());
    }


    public void getPhotos(final Integer limit,
                          final CommonCallback<List<Album>> masterCallback) {
        CoreLog.d("Requesting photos with limit " + limit);
        mNetworkLoader.getPhotos(limit, masterCallback);
    }
}
