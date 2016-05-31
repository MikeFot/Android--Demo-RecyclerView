package com.michaelfotiadis.demorecyclerview.optional;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.michaelfotiadis.demorecyclerview.core.data.loaders.DataProvider;
import com.michaelfotiadis.demorecyclerview.core.data.responses.CommonCallback;
import com.michaelfotiadis.demorecyclerview.core.data.responses.CommonDeliverable;
import com.michaelfotiadis.demorecyclerview.core.data.responses.CommonError;
import com.michaelfotiadis.demorecyclerview.core.models.album.Album;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 */
public class JsonAlbumFragment extends BaseJsonViewFragment {

    private List<Album> mItems;

    public static Fragment newInstance() {
        return new JsonAlbumFragment();
    }

    @Override
    protected void loadData() {
        new DataProvider().getPhotos(10, new CommonCallback<List<Album>>() {
            @Override
            public void onFailure(final CommonError error) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setText(error.getErrorMessage());
                    }
                });

            }

            @Override
            public void onSuccess(final CommonDeliverable<List<Album>> deliverable) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mItems = deliverable.getContent();
                        setUp();
                    }
                });

            }
        });

    }

    @Override
    protected void setUp() {

        final Set<String> set = new TreeSet<>();

        int i = 0;
        for (final Album item : mItems) {

            final String id = "Item No. " + i++ + ": ID= " + item.getId();

            set.add(id);
        }

        final List<String> list = new ArrayList<>();
        list.addAll(set);

        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        setSpinnerAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
        if (mItems != null) {
            setText(mItems.get(position));
        }
    }

    @Override
    public void onNothingSelected(final AdapterView<?> parent) {
        setText("Nothing selected");
    }
}
