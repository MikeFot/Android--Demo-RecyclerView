package com.michaelfotiadis.demorecyclerview.data.converter;

import com.michaelfotiadis.demorecyclerview.core.models.album.Album;
import com.michaelfotiadis.demorecyclerview.data.models.album.UiAlbum;
import com.michaelfotiadis.demorecyclerview.data.models.album.UiAlbumImpl;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@SuppressWarnings("MethodMayBeStatic")
public final class AlbumFactory {


    public AlbumFactory() {
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
                .withTitle(album.getTitle())
                .withSubtitle(album.getUrl())
                .withImageUrl(album.getThumbnailUrl())
                .build();
    }

}
