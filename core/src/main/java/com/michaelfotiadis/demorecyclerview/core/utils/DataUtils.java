package com.michaelfotiadis.demorecyclerview.core.utils;

import android.net.Uri;

/**
 *
 */
public final class DataUtils {
    private static final String PATTERN = "^http(s?)://[a-zA-Z0-9_/\\-\\.]+\\.([A-Za-z/]{2,5})[a-zA-Z0-9_/&\\?=\\-\\.~%]*";

    private DataUtils() {
        // NOOP
    }

    public static boolean isURL(final String url) {
        if (url == null) {
            return false;
        }
        // Assigning the url format regular expression
        return url.matches(PATTERN);
    }

    public static String getLastPath(final String path) {
        final Uri uri = Uri.parse(path);
        return uri == null ? "" : uri.getLastPathSegment();
    }

}
