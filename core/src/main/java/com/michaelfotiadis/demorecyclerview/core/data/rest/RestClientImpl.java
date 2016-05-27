package com.michaelfotiadis.demorecyclerview.core.data.rest;

import com.google.gson.Gson;
import com.michaelfotiadis.demorecyclerview.core.BuildConfig;
import com.michaelfotiadis.demorecyclerview.core.data.api.PhotoApi;
import com.michaelfotiadis.demorecyclerview.core.data.parsers.CoreGson;
import com.michaelfotiadis.demorecyclerview.core.utils.CoreLog;

/**
 * Rest Client class
 */
public final class RestClientImpl implements RestClient {

    private ApiStore mApiStore;

    /**
     * Constructor for the RestClient
     */
    public RestClientImpl() {
        CoreLog.d("Initialising the Rest Client");
    }

    @Override
    public synchronized PhotoApi getPhotoApi() {
        validateApiStore();
        return mApiStore.getPhotoApi();
    }

    private void validateApiStore() {
        final boolean recreate;

        if (mApiStore == null) {
            recreate = true;
        } else {
            final String currentEndpoint = BuildConfig.API_ENDPOINT_STRING;
            final String apiEndpoint = mApiStore.getServerEndpoint();
            recreate = !currentEndpoint.equals(apiEndpoint);
        }

        if (recreate) {
            final String currentEndpoint = BuildConfig.API_ENDPOINT_STRING;
            final Gson gson = CoreGson.get();
            mApiStore = new ApiStore(currentEndpoint, gson);
        }
    }

}