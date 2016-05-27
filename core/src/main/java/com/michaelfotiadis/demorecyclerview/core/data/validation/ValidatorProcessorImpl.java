package com.michaelfotiadis.demorecyclerview.core.data.validation;

import com.michaelfotiadis.demorecyclerview.core.data.validation.validators.AlbumValidator;
import com.michaelfotiadis.demorecyclerview.core.data.validation.validators.Validator;
import com.michaelfotiadis.demorecyclerview.core.models.album.Album;
import com.michaelfotiadis.demorecyclerview.core.models.base.ApiModel;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public final class ValidatorProcessorImpl implements ValidatorProcessor {

    private final Map<Class<? extends ApiModel>, Validator> mValidators;

    public ValidatorProcessorImpl() {
        mValidators = new HashMap<>();

        // add the validators
        mValidators.put(Album.class, new AlbumValidator());

    }

    @Override
    public <T extends ApiModel> Validator<T> getValidator(final Class<T> clazz) {
        //noinspection unchecked
        return mValidators.get(clazz);
    }
}
