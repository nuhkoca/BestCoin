package com.mobilemovement.bestcoin.base;


import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment<B extends ViewDataBinding> extends Fragment {

    protected B fragmentDataBinding;

    protected void initUI(TextView textBase) {
    }
}
