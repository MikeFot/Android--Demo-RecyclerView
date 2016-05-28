package com.michaelfotiadis.demorecyclerview.ui.core.imagefetcher;

import android.widget.ImageView;

/**
 *
 */
public interface ImageFetcher {
    void loadIntoImageView(final String imagePath, final int placeholder, final ImageView imageView);
}
