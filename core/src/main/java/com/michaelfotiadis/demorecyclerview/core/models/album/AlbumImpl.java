package com.michaelfotiadis.demorecyclerview.core.models.album;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class AlbumImpl implements Album {

    @SerializedName("albumId")
    private final Integer albumId;
    @SerializedName("id")
    private final Integer id;
    @SerializedName("title")
    private final String title;
    @SerializedName("url")
    private final String url;
    @SerializedName("thumbnailUrl")
    private final String thumbnailUrl;

    private AlbumImpl(final Builder builder) {
        albumId = builder.albumId;
        id = builder.id;
        title = builder.title;
        url = builder.url;
        thumbnailUrl = builder.thumbnailUrl;
    }

    @Override
    public Integer getAlbumId() {
        return albumId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getUrl() {
        return url;
    }

    protected AlbumImpl(final Parcel in) {
        this.albumId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.title = in.readString();
        this.url = in.readString();
        this.thumbnailUrl = in.readString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final AlbumImpl copy) {
        final Builder builder = new Builder();
        builder.albumId = copy.albumId;
        builder.id = copy.id;
        builder.title = copy.title;
        builder.url = copy.url;
        builder.thumbnailUrl = copy.thumbnailUrl;
        return builder;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeValue(this.albumId);
        dest.writeValue(this.id);
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeString(this.thumbnailUrl);
    }

    public static final class Builder {
        private Integer albumId;
        private Integer id;
        private String title;
        private String url;
        private String thumbnailUrl;

        private Builder() {
        }

        public Builder withAlbumId(final Integer val) {
            albumId = val;
            return this;
        }

        public Builder withId(final Integer val) {
            id = val;
            return this;
        }

        public Builder withTitle(final String val) {
            title = val;
            return this;
        }

        public Builder withUrl(final String val) {
            url = val;
            return this;
        }

        public Builder withThumbnailUrl(final String val) {
            thumbnailUrl = val;
            return this;
        }

        public Album build() {
            return new AlbumImpl(this);
        }
    }
}