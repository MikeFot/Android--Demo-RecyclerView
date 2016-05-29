package com.michaelfotiadis.demorecyclerview.data.adapters;

import com.michaelfotiadis.demorecyclerview.core.models.album.Album;
import com.michaelfotiadis.demorecyclerview.core.utils.DataUtils;
import com.michaelfotiadis.demorecyclerview.data.models.album.UiAlbum;
import com.michaelfotiadis.demorecyclerview.data.models.album.UiAlbumImpl;
import com.michaelfotiadis.demorecyclerview.utils.color.ColorUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for creating ui objects of type {@link UiAlbum} form {@link Album}
 */
@SuppressWarnings("MethodMayBeStatic")
public final class AlbumAdapter {


    public AlbumAdapter() {
        // nothing to see here
    }

    public List<UiAlbum> createUiAlbumList(final List<Album> albums) {

        final List<UiAlbum> uiAlbums = new ArrayList<>();

        for (final Album album : albums) {
            uiAlbums.add(createUiAlbum(album));
        }
        return uiAlbums;
    }

    public UiAlbum createUiAlbum(final Album album) {
        return UiAlbumImpl.newBuilder()
                .withTitle(getTitle(album))
                .withSubtitle(album.getTitle())
                .withImageUrl(album.getThumbnailUrl())
                .withLink(album.getUrl())
                .build();
    }

    protected String getTitle(final Album album) {
        final String hex = DataUtils.getLastPath(album.getUrl());
        return ColorUtils.getColorNameFromHex(hex);
    }

}
