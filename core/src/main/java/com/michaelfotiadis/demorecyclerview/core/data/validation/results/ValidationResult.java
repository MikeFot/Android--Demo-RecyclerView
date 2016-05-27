package com.michaelfotiadis.demorecyclerview.core.data.validation.results;


import com.michaelfotiadis.demorecyclerview.core.data.responses.CommonError;
import com.michaelfotiadis.demorecyclerview.core.data.responses.CommonErrorKind;

/**
 *
 */
public class ValidationResult {

    private final CommonError mError;
    private final boolean mIsValid;


    public ValidationResult(final boolean isValid, final CommonError error) {
        this.mError = error;
        this.mIsValid = isValid;
    }

    public ValidationResult(final boolean isValid, final String errorMessage) {
        this.mError = CommonError.from(errorMessage, CommonErrorKind.INVALID_CONTENT);
        this.mIsValid = isValid;
    }

    public ValidationResult(final boolean isValid) {
        this.mError = null;
        this.mIsValid = isValid;
    }

    public CommonError getError() {
        return mError;
    }

    public boolean isValid() {
        return mIsValid;
    }
}
