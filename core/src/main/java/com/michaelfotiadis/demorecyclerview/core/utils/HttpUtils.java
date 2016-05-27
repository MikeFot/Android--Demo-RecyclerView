package com.michaelfotiadis.demorecyclerview.core.utils;

import org.apache.commons.validator.routines.UrlValidator;

/**
 *
 */
public final class HttpUtils {

    private HttpUtils() {
        // NOOP
    }

    public static boolean isUrlValid(final String address) {
        final String[] schemes = {"http", "https"}; // DEFAULT schemes = "http", "https", "ftp"
        final UrlValidator urlValidator = new UrlValidator(schemes);
        return urlValidator.isValid(address);
    }

}
