package com.michaelfotiadis.demorecyclerview.ui.core.imagefetcher;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

import com.michaelfotiadis.demorecyclerview.utils.AppLog;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.concurrent.ExecutorService;

/**
 *
 */
/*package*/ class PicassoSingleton {
    private static final Bitmap.Config PICASSO_BITMAP_CONFIG = Bitmap.Config.RGB_565;
    //
    // PICASSO SETTINGS
    //
    //@formatter:off
    private static final boolean PICASSO_DEBUG_ENABLED = true;
    private static final ExecutorService PICASSO_EXECUTOR = null; // USE THE DEFAULT PICASSO EXECUTOR
    //@formatter:on

    //
    // SINGLETON INSTANCE
    //
    private static volatile Picasso sInstance;

    public Picasso getInstance(final Context context) {
        Picasso result = sInstance;
        if (result == null) {
            synchronized (this) {
                result = sInstance;
                if (result == null) {
                    sInstance = result = create(context);
                }
            }
        }
        return result;
    }

    private static Picasso create(final Context context) {
        final boolean debugEnabled = PICASSO_DEBUG_ENABLED;
        final Context appContext = context.getApplicationContext();

        AppLog.d("PICASSO: New Instance!");

        final Picasso.Builder builder = new Picasso.Builder(appContext);
        builder.downloader(new OkHttpDownloader(context, Integer.MAX_VALUE));
        builder.indicatorsEnabled(debugEnabled);
        builder.defaultBitmapConfig(PICASSO_BITMAP_CONFIG);

        //noinspection ConstantConditions
        if (PICASSO_EXECUTOR != null) {
            builder.executor(PICASSO_EXECUTOR);
        }

        if (debugEnabled) {
            builder.listener(new PicassoListener());
        }

        return builder.build();
    }

    private static class PicassoListener implements Picasso.Listener {
        @Override
        public void onImageLoadFailed(final Picasso picasso,
                                      final Uri uri,
                                      final Exception e) {
            AppLog.w("PICASSO: Failed to load image: '" + uri + "': " + e.getMessage());
        }
    }
}