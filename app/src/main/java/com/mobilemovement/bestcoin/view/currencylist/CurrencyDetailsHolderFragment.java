package com.mobilemovement.bestcoin.view.currencylist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.base.BaseFragment;
import com.mobilemovement.bestcoin.databinding.FragmentCurrencyDetailsHolderBinding;
import com.mobilemovement.bestcoin.view.currencylist.adapter.CurrencyDetailAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrencyDetailsHolderFragment extends BaseFragment<FragmentCurrencyDetailsHolderBinding> {

    private static CurrencyDetailAdapter mCurrencyDetailAdapter;

    public static CurrencyDetailsHolderFragment newInstance(Bundle args) {
        CurrencyDetailsHolderFragment currencyDetailsHolderFragment = new CurrencyDetailsHolderFragment();
        currencyDetailsHolderFragment.setArguments(args);

        mCurrencyDetailAdapter = new CurrencyDetailAdapter(args);

        return currencyDetailsHolderFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_currency_details_holder;
    }

    @Override
    protected boolean getHasFixedSize() {
        return true;
    }

    @Override
    protected RecyclerView getRecyclerView() {
        return fragmentDataBinding.rvCurrencyItemDetails;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mCurrencyDetailAdapter;
    }

    @Override
    protected void initUI() {}
}
