package com.michaelfotiadis.demorecyclerview.core.data.validation.validators;

import com.michaelfotiadis.demorecyclerview.core.data.validation.results.ValidationResult;
import com.michaelfotiadis.demorecyclerview.core.models.base.BaseApiModel;

/**
 *
 */
public interface Validator<T extends BaseApiModel> {
    ValidationResult validate(T item);
}
