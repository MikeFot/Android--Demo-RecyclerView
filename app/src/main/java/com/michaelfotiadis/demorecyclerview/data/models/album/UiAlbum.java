package com.michaelfotiadis.demorecyclerview.data.models.album;

import android.os.Parcel;

import com.michaelfotiadis.demorecyclerview.data.models.base.BaseUiModel;

/**
 *
 */
public interface UiAlbum extends BaseUiModel {
    Creator<UiAlbum> CREATOR = new Creator<UiAlbum>() {
        @Override
        public UiAlbum createFromParcel(final Parcel source) {
            return new UiAlbumImpl(source);
        }

        @Override
        public UiAlbum[] newArray(final int size) {
            return new UiAlbum[size];
        }
    };

    String getImageUrl();

    String getSubtitle();

    String getTitle();
}
