package com.mobilemovement.bestcoin.base;


import android.content.res.Configuration;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment<B extends ViewDataBinding> extends Fragment {

    protected B fragmentDataBinding;
    protected RecyclerView mRecyclerView;

    protected static final int GRID_LAYOUT_ID = 120;
    protected static final int GRID_LAYOUT_LAND_ID = 121;

    protected static final int LINEAR_LAYOUT_ID = 122;

    private static final int SPAN_COUNT_2 = 2;
    private static final int SPAN_COUNT_4 = 4;

    protected void initUI(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        mRecyclerView = recyclerView;
        mRecyclerView.setNestedScrollingEnabled(false);

        switch (getLayoutId()) {
            case GRID_LAYOUT_ID:
                mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),
                        SPAN_COUNT_2));
                break;
            case GRID_LAYOUT_LAND_ID:
                mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),
                        SPAN_COUNT_4));
                break;
            case LINEAR_LAYOUT_ID:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                break;
            default:
                break;
        }

        if (setHasFixedSize()) {
            mRecyclerView.setHasFixedSize(true);
        } else {
            mRecyclerView.setHasFixedSize(false);
        }

        mRecyclerView.setAdapter(adapter);
    }

    public abstract int getLayoutId();

    public abstract boolean setHasFixedSize();
}