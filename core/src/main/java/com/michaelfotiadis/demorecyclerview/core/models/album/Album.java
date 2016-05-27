package com.michaelfotiadis.demorecyclerview.core.models.album;

import android.os.Parcel;

import com.michaelfotiadis.demorecyclerview.core.models.base.ApiModel;

/**
 *
 */
public interface Album extends ApiModel {
    Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(final Parcel source) {
            return new AlbumImpl(source);
        }

        @Override
        public Album[] newArray(final int size) {
            return new Album[size];
        }
    };

    Integer getAlbumId();

    Integer getId();

    String getThumbnailUrl();

    String getTitle();

    String getUrl();
}
