package com.michaelfotiadis.demorecyclerview.core.data.loaders;

import com.michaelfotiadis.demorecyclerview.core.data.responses.CommonCallback;
import com.michaelfotiadis.demorecyclerview.core.models.album.Album;

import java.util.List;

/**
 */
/*package*/ abstract class Loader {
    protected abstract void getPhotos(Integer limit,
                                      CommonCallback<List<Album>> masterCallback);
}
