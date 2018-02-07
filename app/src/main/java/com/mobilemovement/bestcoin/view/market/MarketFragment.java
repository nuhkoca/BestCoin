package com.mobilemovement.bestcoin.view.market;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.base.BaseFragment;
import com.mobilemovement.bestcoin.databinding.FragmentMarketBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarketFragment extends BaseFragment<FragmentMarketBinding> {

    public static MarketFragment newInstance() {
        return new MarketFragment(); }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_market;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return null;
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return null;
    }

    @Override
    protected void initUI() {

    }

    @Override
    protected boolean performOrientationType() {
        return true;
    }

    @Override
    protected void addExtraToRecyclerview() {
        //fragmentDataBinding.rvCurrencyItemDetails.setHasFixedSize(true);
        //fragmentDataBinding.rvCurrencyItemDetails.setNestedScrollingEnabled(false);
    }
}
