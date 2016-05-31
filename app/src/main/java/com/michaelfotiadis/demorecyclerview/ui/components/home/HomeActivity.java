package com.michaelfotiadis.demorecyclerview.ui.components.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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
        setTitle(getString(R.string.title_home_activity));
        addContentFragmentIfMissing(HomeFragment.newInstance(), FRAGMENT_TAG);

    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        // Handle action bar actions click
        final int itemId = item.getItemId();
        final View view = findViewById(itemId);

        switch (itemId) {
            case R.id.action_open_dev_screen:
                getIntentDispatcher().openDevScreen(view);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

