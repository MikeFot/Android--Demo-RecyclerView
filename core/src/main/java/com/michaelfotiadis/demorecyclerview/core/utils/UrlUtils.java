package com.michaelfotiadis.demorecyclerview.core.utils;

/**
 *
 */
public final class UrlUtils {
    private static final String PATTERN = "^http(s?)://[a-zA-Z0-9_/\\-\\.]+\\.([A-Za-z/]{2,5})[a-zA-Z0-9_/&\\?=\\-\\.~%]*";

    private UrlUtils() {
        // NOOP
    }

    public static boolean isURL(final String url) {
        if (url == null) {
            return false;
        }
        // Assigning the url format regular expression
        return url.matches(PATTERN);
    }

}
