package com.michaelfotiadis.demorecyclerview.optional;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.michaelfotiadis.demorecyclerview.ui.core.common.activity.BaseActivity;

/**
 *
 */
public class DeveloperActivity extends BaseActivity {
    public static Intent getInstance(final Context context) {
        return new Intent(context, DeveloperActivity.class);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        throw new IllegalStateException("You should NOT be here");
    }
}
