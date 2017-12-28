package com.mobilemovement.bestcoin.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mobilemovement.bestcoin.R;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment<F extends ViewDataBinding> extends Fragment {

    protected F fragmentDataBinding;
    protected ProgressBar mPbLoading;
    protected TextView mTvLoading;

    protected static final int GRID_LAYOUT_ID = 120;
    protected static final int GRID_LAYOUT_LAND_ID = 121;
    protected static final int LINEAR_LAYOUT_ID = 122;

    protected static final int SPAN_COUNT_2 = 2;
    protected static final int SPAN_COUNT_4 = 4;

    protected Parcelable mListState;
    protected RecyclerView.LayoutManager mLayoutManager;

    protected static final String LIST_STATE_KEY = "recyclerview-list";

    protected void initGenericUI() {
        mPbLoading = Objects.requireNonNull(getActivity()).findViewById(R.id.pbLoading);
        mTvLoading = Objects.requireNonNull(getActivity()).findViewById(R.id.tvLoading);

        getRecyclerView().setNestedScrollingEnabled(false);

        switch (getLayoutManagerId()) {
            case GRID_LAYOUT_ID:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT_2);
                getRecyclerView().setLayoutManager(mLayoutManager);
                break;
            case GRID_LAYOUT_LAND_ID:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT_4);
                getRecyclerView().setLayoutManager(mLayoutManager);
                break;
            case LINEAR_LAYOUT_ID:
                mLayoutManager = new LinearLayoutManager(getActivity());
                getRecyclerView().setLayoutManager(mLayoutManager);
                break;
            default:
                break;
        }

        if (getHasFixedSize()) {
            getRecyclerView().setHasFixedSize(true);
        } else {
            getRecyclerView().setHasFixedSize(false);
        }

        getRecyclerView().setAdapter(getAdapter());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);

        return Objects.requireNonNull(fragmentDataBinding).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initGenericUI();
        initUI();
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

    /**
     *
     * other methods to be overriden by fragments.
     */

    protected abstract int getLayoutManagerId();

    protected abstract int getLayoutId();

    protected abstract boolean getHasFixedSize();

    protected abstract RecyclerView getRecyclerView();

    protected abstract RecyclerView.Adapter getAdapter();

    protected abstract void initUI();

}