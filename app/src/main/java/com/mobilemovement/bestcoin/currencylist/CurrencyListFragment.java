package com.mobilemovement.bestcoin.currencylist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.base.BaseFragment;
import com.mobilemovement.bestcoin.currencylist.adapter.CurrencyAdapter;
import com.mobilemovement.bestcoin.currencylist.network.FetchCurrencies;
import com.mobilemovement.bestcoin.databinding.FragmentCurrencyListBinding;
import com.mobilemovement.bestcoin.utils.OrientationUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrencyListFragment extends BaseFragment<FragmentCurrencyListBinding> {

    private CurrencyAdapter currencyAdapter = new CurrencyAdapter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_currency_list, container, false);

        return fragmentDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initUI(fragmentDataBinding.rvCoinList,
                currencyAdapter);

        FetchCurrencies.loadCurrencies(currencyAdapter);
    }

    @Override
    public int getLayoutId() {
        int configuration = OrientationUtils.detectOrientation(getActivity());

        if (configuration == 1) {
            return GRID_LAYOUT_ID;
        } else {
            return GRID_LAYOUT_LAND_ID;
        }
    }

    @Override
    public boolean setHasFixedSize() {
        return true;
    }
}