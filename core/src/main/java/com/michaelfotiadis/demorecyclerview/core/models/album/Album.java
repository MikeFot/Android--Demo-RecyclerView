package com.michaelfotiadis.demorecyclerview.core.models.album;

import com.google.gson.annotations.SerializedName;

public class Album {

    @SerializedName("albumId")
    public Integer albumId;
    @SerializedName("id")
    public Integer id;
    @SerializedName("title")
    public String title;
    @SerializedName("url")
    public String url;
    @SerializedName("thumbnailUrl")
    public String thumbnailUrl;

}