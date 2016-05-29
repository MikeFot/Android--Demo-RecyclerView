package com.michaelfotiadis.demorecyclerview.core.utils;

import android.test.AndroidTestCase;

/**
 *
 */
public class DataUtilsTest extends AndroidTestCase {

    public void testIsUrlValid() {

        final String valid1 = "https://www.facebook.com/";
        final String valid2 = "http://9gag.com/";
        final String invalid1 = "9gag.com";
        final String invalid2 = null;
        final String invalid3 = "";

        assertTrue(DataUtils.isURL(valid1));
        assertTrue(DataUtils.isURL(valid2));
        assertFalse(DataUtils.isURL(invalid1));
        assertFalse(DataUtils.isURL(invalid2));
        assertFalse(DataUtils.isURL(invalid3));

    }

    public void testGetPath() throws Exception {

        final String path = "http://placehold.it/600/92c952";

        final String segment = DataUtils.getLastPath(path);

        assertEquals("92c952", segment);

    }

}