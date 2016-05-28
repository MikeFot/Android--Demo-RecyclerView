package com.michaelfotiadis.demorecyclerview.ui.core.intent.factory;

import android.content.Intent;
import android.net.Uri;

/**
 *
 */
public interface IntentFactory {

    Intent getHomeIntent();

    Intent getOpenIntent(Uri uri);
}
