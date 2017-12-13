package com.mobilemovement.bestcoin.base;


import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment<B extends ViewDataBinding> extends Fragment {

    protected B fragmentDataBinding;
    protected RecyclerView mRecyclerView;
    protected static final int STAGGERED_LAYOUT_ID = 120;
    protected static final int LINEAR_LAYOUT_ID = 121;

    protected void initUI(RecyclerView recyclerView, int layoutId, boolean setHasFixedSize, RecyclerView.Adapter adapter) {
        mRecyclerView = recyclerView;

        switch (layoutId) {
            case STAGGERED_LAYOUT_ID:
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            case LINEAR_LAYOUT_ID:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            default:
                break;
        }

        if (setHasFixedSize) {
            mRecyclerView.setHasFixedSize(true);
        } else {
            mRecyclerView.setHasFixedSize(false);
        }

        mRecyclerView.setAdapter(adapter);
    }
}