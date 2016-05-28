package com.michaelfotiadis.demorecyclerview.core.data.validation;

import com.michaelfotiadis.demorecyclerview.core.data.validation.validators.Validator;
import com.michaelfotiadis.demorecyclerview.core.models.base.BaseApiModel;

/**
 *
 */
public interface ValidatorProcessor {
    <T extends BaseApiModel> Validator<T> getValidator(Class<T> clazz);
}
