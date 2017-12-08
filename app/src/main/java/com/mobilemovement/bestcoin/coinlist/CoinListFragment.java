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
import com.mobilemovement.bestcoin.coinlist.adapter.CoinListAdapter;
import com.mobilemovement.bestcoin.coinlist.model.CoinListDataModel;
import com.mobilemovement.bestcoin.coinlist.network.FetchCoinList;
import com.mobilemovement.bestcoin.databinding.FragmentCoinListBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoinListFragment extends BaseFragment<FragmentCoinListBinding> {

    private List<CoinListDataModel> mCoinListDataModel = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_coin_list, container, false);

        fragmentDataBinding.rvCoinList.setHasFixedSize(true);
        fragmentDataBinding.rvCoinList.setLayoutManager(new StaggeredGridLayoutManager(2, 1));

        CoinListAdapter coinListAdapter = new CoinListAdapter(mCoinListDataModel, getActivity());
        fragmentDataBinding.rvCoinList.setAdapter(coinListAdapter);

        FetchCoinList.fetchCoins(coinListAdapter, getActivity());

        return fragmentDataBinding.getRoot();
    }
}