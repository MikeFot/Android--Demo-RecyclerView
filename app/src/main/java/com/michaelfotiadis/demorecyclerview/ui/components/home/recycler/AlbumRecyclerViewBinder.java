package com.michaelfotiadis.demorecyclerview.ui.components.home.recycler;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;

import com.michaelfotiadis.demorecyclerview.R;
import com.michaelfotiadis.demorecyclerview.data.models.album.UiAlbum;
import com.michaelfotiadis.demorecyclerview.ui.core.common.recyclerview.viewbinder.BaseRecyclerViewBinder;
import com.michaelfotiadis.demorecyclerview.ui.core.imagefetcher.ImageFetcher;
import com.michaelfotiadis.demorecyclerview.ui.core.intent.dispatch.IntentDispatcher;

import butterknife.ButterKnife;

/**
 *
 */
public class AlbumRecyclerViewBinder extends BaseRecyclerViewBinder<AlbumRecyclerViewHolder, UiAlbum> {

    private static final int DEFAULT_IMAGE_PLACEHOLDER = R.drawable.ic_insert_photo_black_24dp;

    protected AlbumRecyclerViewBinder(final Context context,
                                      final ImageFetcher imageFetcher,
                                      final IntentDispatcher intentDispatcher) {
        super(context, imageFetcher, intentDispatcher);
    }

    @Override
    public void bind(final AlbumRecyclerViewHolder holder, final UiAlbum item) {
        ButterKnife.bind(holder, holder.getRoot());

        if (item != null) {
            holder.title.setText(item.getTitle());
            holder.subTitle.setText(item.getSubtitle());
            getImageFetcher().loadIntoImageView(
                    item.getImageUrl(),
                    DEFAULT_IMAGE_PLACEHOLDER,
                    holder.imageView
            );

            if (!TextUtils.isEmpty(item.getImageUrl())) {
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        getIntentDispatcher().open(holder.imageView, Uri.parse(item.getSubtitle()));
                    }
                });

            }
        }
    }

    @Override
    public void reset(final AlbumRecyclerViewHolder holder) {
        holder.title.setText("");
        holder.subTitle.setText("");
        holder.imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), DEFAULT_IMAGE_PLACEHOLDER));
    }

}

