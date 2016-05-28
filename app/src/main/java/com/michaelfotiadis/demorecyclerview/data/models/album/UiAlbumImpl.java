package com.michaelfotiadis.demorecyclerview.data.models.album;

import android.os.Parcel;

/**
 *
 */
public class UiAlbumImpl implements UiAlbum {

    private final String mTitle;
    private final String mSubtitle;
    private final String mImageUrl;

    private UiAlbumImpl(final Builder builder) {
        mImageUrl = builder.mImageUrl;
        mTitle = builder.mTitle;
        mSubtitle = builder.mSubtitle;
    }

    protected UiAlbumImpl(final Parcel in) {
        this.mTitle = in.readString();
        this.mSubtitle = in.readString();
        this.mImageUrl = in.readString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final UiAlbumImpl copy) {
        final Builder builder = new Builder();
        builder.mImageUrl = copy.mImageUrl;
        builder.mTitle = copy.mTitle;
        builder.mSubtitle = copy.mSubtitle;
        return builder;
    }

    @Override
    public String getImageUrl() {
        return mImageUrl;
    }

    @Override
    public String getSubtitle() {
        return mSubtitle;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(this.mTitle);
        dest.writeString(this.mSubtitle);
        dest.writeString(this.mImageUrl);
    }

    public static final class Builder {
        private String mImageUrl;
        private String mTitle;
        private String mSubtitle;

        private Builder() {
        }

        public Builder withImageUrl(final String val) {
            this.mImageUrl = val;
            return this;
        }

        public Builder withTitle(final String val) {
            this.mTitle = val;
            return this;
        }

        public Builder withSubtitle(final String val) {
            this.mSubtitle = val;
            return this;
        }

        public UiAlbum build() {
            return new UiAlbumImpl(this);
        }
    }
}
