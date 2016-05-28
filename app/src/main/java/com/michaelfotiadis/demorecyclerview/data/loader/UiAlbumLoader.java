package com.michaelfotiadis.demorecyclerview.data.loader;

import android.app.Activity;

import com.michaelfotiadis.demorecyclerview.core.data.loaders.DataProvider;
import com.michaelfotiadis.demorecyclerview.core.data.responses.CommonCallback;
import com.michaelfotiadis.demorecyclerview.core.data.responses.CommonDeliverable;
import com.michaelfotiadis.demorecyclerview.core.data.responses.CommonError;
import com.michaelfotiadis.demorecyclerview.core.models.album.Album;
import com.michaelfotiadis.demorecyclerview.data.converter.AlbumFactory;
import com.michaelfotiadis.demorecyclerview.data.error.UiDataLoadErrorFactory;
import com.michaelfotiadis.demorecyclerview.data.models.album.UiAlbum;
import com.michaelfotiadis.demorecyclerview.utils.AppLog;

import java.util.List;
import java.util.Locale;

/**
 *
 */
public class UiAlbumLoader extends DataFeedLoaderAbstract<UiAlbum> {

    private static final int PAGE_LIMIT = 10;
    final DataProvider mDataProvider;
    final AlbumFactory mFactory;

    public UiAlbumLoader(final Activity activity) {
        super(activity);
        mDataProvider = new DataProvider();
        mFactory = new AlbumFactory();
    }

    @Override
    public void loadData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // move the current Thread into the background
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                loadAlbums();
            }
        }).start();

    }

    private void loadAlbums() {

        mDataProvider.getPhotos(PAGE_LIMIT, new CommonCallback<List<Album>>() {
            @Override
            public void onFailure(final CommonError error) {
                // convert the error to a ui one
                AppLog.w(String.format("Error loading albums: %s", error));
                notifyError(UiDataLoadErrorFactory.createError(getActivity(), error));
            }

            @Override
            public void onSuccess(final CommonDeliverable<List<Album>> deliverable) {
                AppLog.d(String.format(Locale.UK, "%d albums loaded", deliverable.getContent().size()));
                final List<UiAlbum> uiAlbums = mFactory.createUiAlbumList(deliverable.getContent());
                AppLog.d(String.format(Locale.UK, "%d ui albums converted", uiAlbums.size()));
                notifySuccess(uiAlbums);

            }
        });
    }
}
