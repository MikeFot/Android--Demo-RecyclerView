package com.michaelfotiadis.demorecyclerview.ui.core.intent.dispatch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.michaelfotiadis.demorecyclerview.ui.core.intent.NavLog;
import com.michaelfotiadis.demorecyclerview.ui.core.intent.factory.IntentFactory;
import com.michaelfotiadis.demorecyclerview.ui.core.intent.factory.IntentFactoryImpl;
import com.michaelfotiadis.demorecyclerview.utils.AppLog;


/**
 *
 */
public class IntentDispatcherImpl implements IntentDispatcher {

    private final IntentDispatcherInternal mDispatcher;
    private final IntentFactory mIntentFactory;

    public IntentDispatcherImpl(final Activity activity) {
        this.mIntentFactory = new IntentFactoryImpl(activity);
        this.mDispatcher = new IntentDispatcherInternal(activity);
    }

    @Override
    public void open(final View source, final Uri uri) {
        NavLog.d("Opening Uri: " + uri);
        final Intent intent = mIntentFactory.getOpenIntent(uri);
        mDispatcher
                .withView(source)
                .withAnimation(ActivityAnimation.SCALE_UP_FROM_VIEW)
                .dispatch(intent);
    }

    @Override
    public void dispatch(final View source, final Intent intent) {
        mDispatcher
                .withView(source)
                .withAnimation(ActivityAnimation.SCALE_UP_FROM_VIEW)
                .dispatch(intent);
    }

    @Override
    public void dispatchForResult(final View source, final Intent intent, final int requestCode) {
        mDispatcher
                .withView(source)
                .withAnimation(ActivityAnimation.SCALE_UP_FROM_VIEW)
                .forResult(requestCode)
                .dispatch(intent);
    }

    @Override
    public void openHomeActivity() {
        AppLog.d("Starting sign-in activity");
        final Intent intent = mIntentFactory.getHomeIntent();
        mDispatcher
                .withAnimation(ActivityAnimation.SLIDE_UP_FROM_BOTTOM)
                .dispatch(intent);
    }

}
