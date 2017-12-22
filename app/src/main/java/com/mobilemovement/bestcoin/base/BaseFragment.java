package com.mobilemovement.bestcoin.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment<B extends ViewDataBinding> extends Fragment {

    protected B fragmentDataBinding;
    protected RecyclerView mRecyclerView;

    protected static final int GRID_LAYOUT_ID = 120;
    protected static final int GRID_LAYOUT_LAND_ID = 121;

    protected static final int LINEAR_LAYOUT_ID = 122;

    protected static final int SPAN_COUNT_2 = 2;
    protected static final int SPAN_COUNT_4 = 4;

    protected Parcelable mListState;
    protected RecyclerView.LayoutManager mLayoutManager;

    protected static final String LIST_STATE_KEY = "recyclerview-list";

    protected void initUI(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        mRecyclerView = recyclerView;
        mRecyclerView.setNestedScrollingEnabled(false);

        switch (getLayoutId()) {
            case GRID_LAYOUT_ID:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT_2);
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            case GRID_LAYOUT_LAND_ID:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT_4);
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            case LINEAR_LAYOUT_ID:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mRecyclerView.setLayoutManager(mLayoutManager);
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        mListState = mLayoutManager.onSaveInstanceState();

        outState.putParcelable(LIST_STATE_KEY, mListState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null)
            mListState = savedInstanceState.getParcelable(LIST_STATE_KEY);
    }

    @Override
    public void onResume() {
        super.onResume();

        if (mListState != null) {
            mLayoutManager.onRestoreInstanceState(mListState);
        }
    }
}