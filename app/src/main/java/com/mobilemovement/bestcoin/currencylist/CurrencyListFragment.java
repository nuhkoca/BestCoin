package com.mobilemovement.bestcoin.currencylist;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.base.BaseFragment;
import com.mobilemovement.bestcoin.currencylist.adapter.CurrencyAdapter;
import com.mobilemovement.bestcoin.currencylist.network.FetchCurrencies;
import com.mobilemovement.bestcoin.databinding.FragmentCurrencyListBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrencyListFragment extends BaseFragment<FragmentCurrencyListBinding> {

    private static final int SPAN_COUNT = 2;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_currency_list, container, false);

        CurrencyAdapter currencyAdapter = new CurrencyAdapter();

        fragmentDataBinding.rvCoinList.setLayoutManager(new StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL));
        fragmentDataBinding.rvCoinList.setHasFixedSize(false);

        initUI(fragmentDataBinding.rvCoinList,
                currencyAdapter);

        FetchCurrencies.loadCurrencies(currencyAdapter);

        return fragmentDataBinding.getRoot();
    }
}