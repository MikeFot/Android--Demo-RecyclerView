package com.michaelfotiadis.demorecyclerview.ui.components.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.michaelfotiadis.demorecyclerview.R;
import com.michaelfotiadis.demorecyclerview.ui.core.common.activity.BaseActivity;

public class HomeActivity extends BaseActivity {

    private static final int LAYOUT_ID = R.layout.activity_default_fragment_container;
    private static final String FRAGMENT_TAG = HomeActivity.class.getSimpleName() + "_fragment_tag";


    public static Intent getInstance(final Context context) {
        return new Intent(context, HomeActivity.class);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(LAYOUT_ID);

        addContentFragmentIfMissing(HomeFragment.newInstance(), FRAGMENT_TAG);

    }

}

