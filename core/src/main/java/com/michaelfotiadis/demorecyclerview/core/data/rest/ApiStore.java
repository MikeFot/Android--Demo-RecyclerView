package com.michaelfotiadis.demorecyclerview.core.data.rest;

import com.google.gson.Gson;
import com.michaelfotiadis.demorecyclerview.core.data.api.PhotoApi;
import com.michaelfotiadis.demorecyclerview.core.utils.CoreLog;

import retrofit2.Retrofit;


/**
 *
 */
/*protected*/ class ApiStore {
    private final String mServerEndpoint;

    private final PhotoApi mPhotoApi;

    public ApiStore(final String serverEndpoint, final Gson gson) {
        CoreLog.d("New Retrofit API. Endpoint is " + serverEndpoint);

        mServerEndpoint = serverEndpoint;

        final Retrofit adapter = RestAdapterFactory.createDefault(serverEndpoint, gson);

        mPhotoApi = adapter.create(PhotoApi.class);

    }

    public PhotoApi getPhotoApi() {
        return mPhotoApi;
    }

    public String getServerEndpoint() {
        return mServerEndpoint;
    }
}
