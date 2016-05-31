package com.michaelfotiadis.demorecyclerview.optional;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.michaelfotiadis.demorecyclerview.R;
import com.michaelfotiadis.demorecyclerview.ui.core.common.activity.BaseActivity;

public class DeveloperActivity extends BaseActivity {

    private static final String FRAGMENT_TAG = DeveloperActivity.class.getSimpleName() + "_fragment_tag";

    public static Intent getInstance(final Context context) {
        return new Intent(context, DeveloperActivity.class);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_fragment_container);
        setTitle("Here there be dragons");
        addContentFragmentIfMissing(JsonAlbumFragment.newInstance(), FRAGMENT_TAG);
    }
}
