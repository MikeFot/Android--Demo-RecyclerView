package com.michaelfotiadis.demorecyclerview.data.adapters;

import com.michaelfotiadis.demorecyclerview.core.models.album.Album;
import com.michaelfotiadis.demorecyclerview.data.models.album.UiAlbum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 */
public class AlbumAdapterTest {

    private static final String URL_1_1 = "http://google.com/1";
    private static final String URL_1_2 = "https://www.facebook.com/1";
    private static final String URL_2_1 = "http://google.com/2";
    private static final String URL_2_2 = "https://www.facebook.com/2";

    @Test
    public void testCreateUiAlbumList() throws Exception {

        final List<Album> albumList = new ArrayList<>();

        final Album album1 = getAlbum1();
        assertNotNull(album1);
        final Album album2 = getAlbum2();
        assertNotNull(album2);

        albumList.add(album1);
        albumList.add(album2);

        final AlbumAdapter factory = new AlbumAdapter();
        assertNotNull(factory);
        final List<UiAlbum> result = factory.createUiAlbumList(albumList);

        assertNotNull(result);
        assertEquals(2, result.size());

        final UiAlbum uiAlbum1 = result.get(0);

        assertNotNull(uiAlbum1);
        assertEquals(album1.getTitle(), uiAlbum1.getTitle());
        assertEquals(album1.getThumbnailUrl(), uiAlbum1.getImageUrl());
        assertEquals(album1.getUrl(), uiAlbum1.getSubtitle());

        assertNotNull(album2);
        final UiAlbum uiAlbum2 = result.get(1);

        assertNotNull(uiAlbum2);
        assertEquals(album2.getTitle(), uiAlbum2.getTitle());
        assertEquals(album2.getThumbnailUrl(), uiAlbum2.getImageUrl());
        assertEquals(album2.getUrl(), uiAlbum2.getSubtitle());

    }

    @Test
    public void testCreateUiAlbum() throws Exception {

        final AlbumAdapter factory = new AlbumAdapter();
        assertNotNull(factory);
        final Album album1 = getAlbum1();
        assertNotNull(album1);
        final UiAlbum uiAlbum1 = factory.createUiAlbum(album1);

        assertNotNull(uiAlbum1);
        assertEquals(album1.getTitle(), uiAlbum1.getTitle());
        assertEquals(album1.getThumbnailUrl(), uiAlbum1.getImageUrl());
        assertEquals(album1.getUrl(), uiAlbum1.getSubtitle());

        final Album album2 = getAlbum2();
        assertNotNull(album2);
        final UiAlbum uiAlbum2 = factory.createUiAlbum(album2);

        assertNotNull(uiAlbum2);
        assertEquals(album2.getTitle(), uiAlbum2.getTitle());
        assertEquals(album2.getThumbnailUrl(), uiAlbum2.getImageUrl());
        assertEquals(album2.getUrl(), uiAlbum2.getSubtitle());

    }

    private static Album getAlbum1() {
        final Album album1 = mock(Album.class);

        when(album1.getId()).thenReturn(1);
        when(album1.getTitle()).thenReturn("1");
        when(album1.getThumbnailUrl()).thenReturn(URL_1_1);
        when(album1.getUrl()).thenReturn(URL_1_2);

        return album1;
    }

    private static Album getAlbum2() {
        final Album album1 = mock(Album.class);

        when(album1.getId()).thenReturn(2);
        when(album1.getTitle()).thenReturn("2");
        when(album1.getThumbnailUrl()).thenReturn(URL_2_1);
        when(album1.getUrl()).thenReturn(URL_2_2);

        return album1;
    }
}