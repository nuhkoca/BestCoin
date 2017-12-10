package com.mobilemovement.bestcoin.base;


import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment<B extends ViewDataBinding> extends Fragment {

    protected B fragmentDataBinding;
    protected RecyclerView mRecyclerView;

    protected void initUI(RecyclerView recyclerView, RecyclerView.LayoutManager layoutManager, RecyclerView.Adapter adapter) {
        mRecyclerView = recyclerView;

        recyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(adapter);
    }
}