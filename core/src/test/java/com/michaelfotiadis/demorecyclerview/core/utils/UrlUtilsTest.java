package com.michaelfotiadis.demorecyclerview.core.utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class UrlUtilsTest {

    @Test
    public void testIsUrlValid() throws Exception {

        final String valid1 = "https://www.facebook.com/";
        final String valid2 = "http://9gag.com/";
        final String invalid1 = "9gag.com";
        final String invalid2 = null;
        final String invalid3 = "";

        assertTrue(UrlUtils.isURL(valid1));
        assertTrue(UrlUtils.isURL(valid2));
        assertFalse(UrlUtils.isURL(invalid1));
        assertFalse(UrlUtils.isURL(invalid2));
        assertFalse(UrlUtils.isURL(invalid3));

    }
}