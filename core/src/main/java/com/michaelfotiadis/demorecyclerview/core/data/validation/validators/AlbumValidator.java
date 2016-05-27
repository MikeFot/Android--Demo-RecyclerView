package com.michaelfotiadis.demorecyclerview.core.data.validation.validators;

import android.text.TextUtils;

import com.michaelfotiadis.demorecyclerview.core.data.validation.results.ValidationResult;
import com.michaelfotiadis.demorecyclerview.core.models.album.Album;

/**
 *
 */
public class AlbumValidator implements Validator<Album> {

    @Override
    public ValidationResult validate(final Album item) {
        if (item == null) {
            return new ValidationResult(false, "Null Album");
        } else if (item.getId() == null) {
            return new ValidationResult(false, "Null Album id");
        } else if (TextUtils.isEmpty(item.getUrl())) {
            return new ValidationResult(false, "Null Album image url");
        } else {
            return new ValidationResult(true);
        }
    }
}
