package com.michaelfotiadis.demorecyclerview.core.utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class HttpUtilsTest {

    @Test
    public void testIsUrlValid() throws Exception {

        final String valid1 = "https://www.facebook.com/";
        final String valid2 = "http://9gag.com/";
        final String invalid1 = "9gag.com";
        final String invalid2 = null;
        final String invalid3 = "";

        assertTrue(HttpUtils.isUrlValid(valid1));
        assertTrue(HttpUtils.isUrlValid(valid2));
        assertFalse(HttpUtils.isUrlValid(invalid1));
        assertFalse(HttpUtils.isUrlValid(invalid2));
        assertFalse(HttpUtils.isUrlValid(invalid3));

    }
}