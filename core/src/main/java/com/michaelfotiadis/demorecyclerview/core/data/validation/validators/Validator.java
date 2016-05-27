package com.michaelfotiadis.demorecyclerview.core.data.validation.validators;

import com.michaelfotiadis.demorecyclerview.core.data.validation.results.ValidationResult;
import com.michaelfotiadis.demorecyclerview.core.models.base.ApiModel;

/**
 *
 */
public interface Validator<T extends ApiModel> {
    ValidationResult validate(T item);
}
