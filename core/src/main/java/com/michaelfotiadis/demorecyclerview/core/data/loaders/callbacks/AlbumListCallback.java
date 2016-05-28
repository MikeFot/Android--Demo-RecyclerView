package com.michaelfotiadis.demorecyclerview.core.data.loaders.callbacks;

import com.michaelfotiadis.demorecyclerview.core.data.error.LoaderUtils;
import com.michaelfotiadis.demorecyclerview.core.data.responses.CommonCallback;
import com.michaelfotiadis.demorecyclerview.core.data.responses.CommonDeliverable;
import com.michaelfotiadis.demorecyclerview.core.data.responses.CommonError;
import com.michaelfotiadis.demorecyclerview.core.data.responses.CommonErrorKind;
import com.michaelfotiadis.demorecyclerview.core.data.validation.ValidatorProcessorImpl;
import com.michaelfotiadis.demorecyclerview.core.data.validation.results.ValidationResult;
import com.michaelfotiadis.demorecyclerview.core.data.validation.validators.Validator;
import com.michaelfotiadis.demorecyclerview.core.models.album.Album;
import com.michaelfotiadis.demorecyclerview.core.utils.CoreLog;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumListCallback implements Callback<List<Album>> {
    private final CommonCallback<List<Album>> masterCallback;

    public AlbumListCallback(final CommonCallback<List<Album>> masterCallback) {
        this.masterCallback = masterCallback;
    }

    @Override
    public void onResponse(final Call<List<Album>> call,
                           final Response<List<Album>> response) {

        // checking 200 is good enough for the demo!
        if (response.code() == 200) {
            final ValidationResult result = validateResults(response.body());
            if (result.isValid()) {
                CoreLog.d(String.format(Locale.UK, "Received %d valid Albums", response.body().size()));
                masterCallback.onSuccess(CommonDeliverable.from(response.body()));
            } else {
                CoreLog.w(String.format("Validation error for albums %s", result.getError().getErrorMessage()));
                masterCallback.onFailure(result.getError());
            }
        } else {
            // create an internal error from the code
            CoreLog.e("Communication error while retrieving albums: code= " + response.code());
            masterCallback.onFailure(LoaderUtils.getErrorFromHttpCode(response.code()));
        }

    }

    @Override
    public void onFailure(final Call<List<Album>> call, final Throwable t) {
        CoreLog.e("Communication error while retrieving albums: throwable " + t.getMessage());
        masterCallback.onFailure(CommonError.from(t.getMessage(), CommonErrorKind.COMMUNICATION));
    }

    private static ValidationResult validateResults(final List<Album> items) {

        final Validator<Album> validator = new ValidatorProcessorImpl().getValidator(Album.class);

        for (final Album item : items) {
            final ValidationResult result = validator.validate(item);
            if (!result.isValid()) {
                return result;
            }
        }

        return new ValidationResult(true);
    }

}