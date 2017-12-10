package com.mobilemovement.bestcoin.coinlist;


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
import com.mobilemovement.bestcoin.coinlist.adapter.CurrencyAdapter;
import com.mobilemovement.bestcoin.coinlist.network.FetchCoinList;
import com.mobilemovement.bestcoin.databinding.FragmentCoinListBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoinListFragment extends BaseFragment<FragmentCoinListBinding> {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_coin_list, container, false);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);

        CurrencyAdapter currencyAdapter = new CurrencyAdapter();

        initUI(fragmentDataBinding.rvCoinList,
                staggeredGridLayoutManager,
                currencyAdapter);

        FetchCoinList.loadCurrencies(currencyAdapter);

        return fragmentDataBinding.getRoot();
    }
}