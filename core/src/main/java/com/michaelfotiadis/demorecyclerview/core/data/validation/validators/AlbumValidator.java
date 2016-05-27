package com.michaelfotiadis.demorecyclerview.core.data.validation.validators;

import com.michaelfotiadis.demorecyclerview.core.data.validation.results.ValidationResult;
import com.michaelfotiadis.demorecyclerview.core.models.album.Album;
import com.michaelfotiadis.demorecyclerview.core.utils.HttpUtils;

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
        } else if (!HttpUtils.isUrlValid(item.getUrl())) {
            return new ValidationResult(false, "Invalid Album image url");
        } else {
            return new ValidationResult(true);
        }
    }
}
