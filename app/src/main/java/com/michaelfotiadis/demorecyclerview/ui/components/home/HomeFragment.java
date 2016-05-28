package com.michaelfotiadis.demorecyclerview.ui.components.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michaelfotiadis.demorecyclerview.R;
import com.michaelfotiadis.demorecyclerview.data.error.UiDataLoadError;
import com.michaelfotiadis.demorecyclerview.data.loader.DataFeedLoaderCallback;
import com.michaelfotiadis.demorecyclerview.data.loader.UiAlbumLoader;
import com.michaelfotiadis.demorecyclerview.data.models.album.UiAlbum;
import com.michaelfotiadis.demorecyclerview.ui.components.home.recycler.AlbumRecyclerViewAdapter;
import com.michaelfotiadis.demorecyclerview.ui.core.common.error.errorpage.QuoteOnClickListenerWrapper;
import com.michaelfotiadis.demorecyclerview.ui.core.common.fragment.BaseFragment;
import com.michaelfotiadis.demorecyclerview.ui.core.common.fragment.DataLoader;
import com.michaelfotiadis.demorecyclerview.ui.core.common.recyclerview.manager.RecyclerManager;
import com.michaelfotiadis.demorecyclerview.ui.core.common.viewmanagement.SimpleUiStateKeeper;
import com.michaelfotiadis.demorecyclerview.ui.core.common.viewmanagement.UiStateKeeper;
import com.michaelfotiadis.demorecyclerview.utils.AppLog;
import com.michaelfotiadis.demorecyclerview.utils.DeviceFormUtils;

import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 */
public class HomeFragment extends BaseFragment implements DataLoader {

    @Bind(R.id.recycler_view)
    protected RecyclerView mRecyclerView;
    protected RecyclerManager<UiAlbum> mRecyclerManager;

    public static BaseFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_default_recycler, container, false);
    }

    @Override
    public void onViewCreated(final View view,
                              @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        final UiStateKeeper uiStateKeeper = new SimpleUiStateKeeper(view, mRecyclerView);

        final int columns = new DeviceFormUtils(getContext()).getColumnsForScreen();
        AppLog.d("Number of columns: " + columns);

        final GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), columns);
        mLayoutManager.setOrientation(GridLayoutManager.VERTICAL);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerManager = new RecyclerManager.Builder<>(
                new AlbumRecyclerViewAdapter(
                        getActivity(),
                        getImageFetcher(),
                        getIntentDispatcher()))
                .setRecycler(mRecyclerView)
                .setStateKeeper(uiStateKeeper)
                .setEmptyMessage(getString(R.string.friendly_error_no_data))
                .build();

    }

    @Override
    public void onResume() {
        super.onResume();
        mRecyclerManager.updateUiState();
        if (mRecyclerManager.getItemCount() == 0) {
            AppLog.d("Adapter is empty. Loading data.");
            loadData();
        }
    }

    @Override
    public void loadData() {

        final UiAlbumLoader loader = new UiAlbumLoader(getActivity());

        loader.setCallback(new DataFeedLoaderCallback<UiAlbum>() {
            @Override
            public void onError(final UiDataLoadError error) {
                AppLog.e(String.format("Error %s", error));
                handleError(error);
            }

            @Override
            public void onSuccess(final List<UiAlbum> items) {
                AppLog.d(String.format(Locale.UK, "Loaded %d Ui albums", items.size()));
                mRecyclerManager.clearError();
                mRecyclerManager.setItems(items);

            }
        });
        AppLog.d("Loading Albums");
        mRecyclerManager.updateUiState();
        loader.loadData();
    }

    protected void handleError(final UiDataLoadError error) {
        if (error.isRecoverable()) {
            final QuoteOnClickListenerWrapper wrapper = new QuoteOnClickListenerWrapper(
                    R.string.button_label_error_try_again,
                    new View.OnClickListener() {
                        @Override
                        public void onClick(final View view) {
                            loadData();
                        }
                    });
            mRecyclerManager.setError(error.getMessage(), wrapper);
        } else {
            mRecyclerManager.setError(error.getMessage());
        }
    }

}
