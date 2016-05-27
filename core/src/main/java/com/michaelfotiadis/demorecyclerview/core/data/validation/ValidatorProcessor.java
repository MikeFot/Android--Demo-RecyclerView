package com.michaelfotiadis.demorecyclerview.core.data.validation;

import com.michaelfotiadis.demorecyclerview.core.data.validation.validators.Validator;
import com.michaelfotiadis.demorecyclerview.core.models.base.ApiModel;

/**
 *
 */
public interface ValidatorProcessor {
    <T extends ApiModel> Validator<T> getValidator(Class<T> clazz);
}
