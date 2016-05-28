package com.michaelfotiadis.demorecyclerview.ui.core.common.viewbinder;

import android.content.Context;
import android.view.View;

import com.michaelfotiadis.demorecyclerview.data.models.base.BaseUiModel;
import com.michaelfotiadis.demorecyclerview.ui.core.common.viewholder.BaseViewHolder;
import com.michaelfotiadis.demorecyclerview.ui.core.imagefetcher.ImageFetcher;
import com.michaelfotiadis.demorecyclerview.ui.core.intent.dispatch.IntentDispatcher;
import com.michaelfotiadis.demorecyclerview.utils.view.ViewUtils;

/**
 *
 */
public abstract class BaseViewDataBinder<VH extends BaseViewHolder, D extends BaseUiModel> {

    private final Context mContext;
    private final ImageFetcher mImageFetcher;
    private final IntentDispatcher mIntentDispatcher;

    protected BaseViewDataBinder(final Context context,
                                 final ImageFetcher imageFetcher,
                                 final IntentDispatcher intentDispatcher) {
        this.mContext = context;
        this.mImageFetcher = imageFetcher;
        this.mIntentDispatcher = intentDispatcher;
    }

    public Context getContext() {
        return mContext;
    }

    public IntentDispatcher getIntentDispatcher() {
        return mIntentDispatcher;
    }

    protected ImageFetcher getImageFetcher() {
        return mImageFetcher;
    }

    public abstract void bind(final VH holder, final D item);

    public abstract void reset(final VH holder);

    public void showView(final View view, final boolean show) {
        ViewUtils.showView(view, show);
    }

}
