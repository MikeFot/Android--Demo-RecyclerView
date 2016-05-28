package com.michaelfotiadis.demorecyclerview.ui.core.imagefetcher;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

/**
 *
 */
/*package*/ class PicassoWrapper {
    private static final PicassoSingleton PICASSO_SINGLETON = new PicassoSingleton();
    private final Activity mActivity;

    public PicassoWrapper(final Activity activity) {
        mActivity = activity;
    }

    public void load(final ImageFetcherRequest request, final ImageView imageView, final ImageFetcherCallback callback) {
        if (request.getDrawableId() > 0) {
            loadInternal(getPicasso(mActivity).load(request.getDrawableId()),
                    request,
                    imageView,
                    callback);
        } else {
            final String path = TextUtils.isEmpty(request.getPath()) ? null : request.getPath();
            loadInternal(getPicasso(mActivity).load(path),
                    request,
                    imageView,
                    callback);
        }
    }

    private void loadInternal(final RequestCreator creator,
                              final ImageFetcherRequest request,
                              final ImageView imageView,
                              final ImageFetcherCallback callback) {

        creator.error(request.getErrorResId())
                .placeholder(request.getPlaceholderResId());


        if (request.getScaleType() == ScaleType.CENTER_CROP) {
            creator.fit().centerCrop();
        } else if (request.getScaleType() == ScaleType.CENTER_INSIDE) {
            creator.fit().centerInside();
        }

        final Callback picassoCallback = getWrappedCallback(callback);
        //noinspection AnonymousInnerClassMayBeStatic
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                creator.into(imageView, picassoCallback);
            }
        });
    }

    private static Picasso getPicasso(final Context context) {
        return PICASSO_SINGLETON.getInstance(context);
    }

    private static Callback getWrappedCallback(final ImageFetcherCallback callback) {
        final Callback picassoCallback;

        //noinspection IfMayBeConditional
        if (callback == null) {
            picassoCallback = null;
        } else {
            //noinspection AnonymousInnerClassMayBeStatic
            picassoCallback = new Callback.EmptyCallback() {
                @Override
                public void onError() {
                    callback.onFailure();
                }

                @Override
                public void onSuccess() {
                    callback.onSuccess();
                }
            };
        }

        return picassoCallback;
    }

}
