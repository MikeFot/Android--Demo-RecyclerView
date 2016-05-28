package com.michaelfotiadis.demorecyclerview.ui.components.home.recycler;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michaelfotiadis.demorecyclerview.data.models.album.UiAlbum;
import com.michaelfotiadis.demorecyclerview.ui.core.common.recyclerview.adapter.BaseRecyclerViewAdapter;
import com.michaelfotiadis.demorecyclerview.ui.core.imagefetcher.ImageFetcher;
import com.michaelfotiadis.demorecyclerview.ui.core.intent.dispatch.IntentDispatcher;

/**
 *
 */
public class AlbumRecyclerViewAdapter extends BaseRecyclerViewAdapter<UiAlbum, AlbumRecyclerViewHolder> {

    private final AlbumRecyclerViewBinder mBinder;

    public AlbumRecyclerViewAdapter(final Activity activity,
                                    final ImageFetcher imageFetcher,
                                    final IntentDispatcher intentDispatcher) {
        super(activity, imageFetcher, intentDispatcher);
        mBinder = new AlbumRecyclerViewBinder(activity, getImageFetcher(), getIntentDispatcher());
    }

    @Override
    protected boolean isItemValid(final UiAlbum item) {
        return item != null;
    }

    @Override
    public AlbumRecyclerViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        final View view = LayoutInflater.from(parent.getContext())
                .inflate(AlbumRecyclerViewHolder.getLayoutId(), parent, false);

        return new AlbumRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AlbumRecyclerViewHolder holder,
                                 final int position) {

        final UiAlbum item = getItem(position);

        mBinder.bind(holder, item);

    }

}
