package com.michaelfotiadis.demorecyclerview.core.data.validation;

import com.michaelfotiadis.demorecyclerview.core.data.validation.validators.AlbumValidator;
import com.michaelfotiadis.demorecyclerview.core.data.validation.validators.Validator;
import com.michaelfotiadis.demorecyclerview.core.models.album.Album;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class ValidatorProcessorImplTest {

    @Test
    public void testGetValidator() throws Exception {
        final ValidatorProcessor processor = new ValidatorProcessorImpl();

        final Validator validator = processor.getValidator(Album.class);
        assertNotNull("Null validator", validator);
        assertTrue(AlbumValidator.class.isInstance(validator));

    }
}