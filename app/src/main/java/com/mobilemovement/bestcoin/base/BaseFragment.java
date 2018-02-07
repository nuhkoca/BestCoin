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
import com.mobilemovement.bestcoin.utils.OrientationUtils;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment<F extends ViewDataBinding> extends Fragment {

    protected F fragmentDataBinding;
    protected ProgressBar mPbLoading;
    protected TextView mTvLoading;

    protected int orientationType;

    protected static final int GRID_LAYOUT_ID = 120;
    protected static final int GRID_LAYOUT_LAND_ID = 121;
    protected static final int LINEAR_LAYOUT_ID = 122;

    protected Parcelable mListState;
    protected RecyclerView.LayoutManager mLayoutManager;

    protected static final String LIST_STATE_KEY = "recyclerview-list";

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

    @Override
    public void onDestroy() {
        mListState = null;
        mLayoutManager = null;
        mPbLoading = null;
        mTvLoading = null;

        super.onDestroy();
    }

    /**
     * other methods to be overriden by fragments.
     */

    protected abstract int getLayoutId();

    protected abstract RecyclerView getRecyclerView();

    protected abstract RecyclerView.Adapter getAdapter();

    protected abstract void initUI();

    protected void initGenericUI() {
        mPbLoading = Objects.requireNonNull(getActivity()).findViewById(R.id.pbLoading);
        mTvLoading = Objects.requireNonNull(getActivity()).findViewById(R.id.tvLoading);

        if (getRecyclerView() != null) {
            switch (getOrientationType()) {
                case GRID_LAYOUT_ID:
                    mLayoutManager = new GridLayoutManager(getActivity(), getResources().getInteger(R.integer.grid_layout_column_2));
                    break;
                case GRID_LAYOUT_LAND_ID:
                    mLayoutManager = new GridLayoutManager(getActivity(), getResources().getInteger(R.integer.grid_layout_column_4));
                    break;
                case LINEAR_LAYOUT_ID:
                    mLayoutManager = new LinearLayoutManager(getActivity());
                    break;
                default:
                    break;
            }

            getRecyclerView().setLayoutManager(mLayoutManager);

            addExtraToRecyclerview();

            if (getAdapter() != null) {
                getRecyclerView().setAdapter(getAdapter());
            }
        }
    }

    private int getOrientationType() {
        if (performOrientationType()) {
            int screenMode = OrientationUtils.detectOrientation(Objects.requireNonNull(getActivity()));

            switch (screenMode) {
                case 1:
                    orientationType = GRID_LAYOUT_ID;
                    return orientationType;
                case 2:
                    orientationType = GRID_LAYOUT_LAND_ID;
                    return orientationType;
                default:
                    orientationType = LINEAR_LAYOUT_ID;
                    return orientationType;
            }
        }

        return LINEAR_LAYOUT_ID;
    }

    protected abstract boolean performOrientationType();

    protected abstract void addExtraToRecyclerview();
}