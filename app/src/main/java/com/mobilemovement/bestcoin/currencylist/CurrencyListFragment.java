package com.mobilemovement.bestcoin.currencylist;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.base.BaseFragment;
import com.mobilemovement.bestcoin.currencylist.adapter.CurrencyAdapter;
import com.mobilemovement.bestcoin.currencylist.network.FetchCurrencies;
import com.mobilemovement.bestcoin.databinding.FragmentCoinListBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrencyListFragment extends BaseFragment<FragmentCoinListBinding> {

    final boolean setHasFixedSize = true;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_currency_list, container, false);

        CurrencyAdapter currencyAdapter = new CurrencyAdapter();

        initUI(fragmentDataBinding.rvCoinList,
                STAGGERED_LAYOUT_ID,
                setHasFixedSize,
                currencyAdapter);

        FetchCurrencies.loadCurrencies(currencyAdapter, getActivity());

        return fragmentDataBinding.getRoot();
    }
}