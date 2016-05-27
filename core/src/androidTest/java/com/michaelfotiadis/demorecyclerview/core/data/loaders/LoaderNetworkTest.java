package com.michaelfotiadis.demorecyclerview.core.data.loaders;

import android.test.AndroidTestCase;

import com.michaelfotiadis.demorecyclerview.core.data.rest.RestClientImpl;

/**
 *
 */
public class LoaderNetworkTest extends AndroidTestCase {

    public void testInit() throws Exception {
        final LoaderNetwork loader = new LoaderNetwork(new RestClientImpl());
        assertNotNull(loader);
    }

}