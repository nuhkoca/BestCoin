package com.mobilemovement.bestcoin.view.market;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.base.BaseFragment;
import com.mobilemovement.bestcoin.databinding.FragmentMarketBinding;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarketFragment extends BaseFragment<FragmentMarketBinding> {

    FragmentMarketBinding mFragmentMarketBinding;

    public MarketFragment() {}


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentMarketBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_market, container, false);

        return Objects.requireNonNull(mFragmentMarketBinding).getRoot();
    }

    @Override
    public int getLayoutId() {
        return GRID_LAYOUT_ID;
    }

    @Override
    public boolean setHasFixedSize() {
        return false;
    }
}
