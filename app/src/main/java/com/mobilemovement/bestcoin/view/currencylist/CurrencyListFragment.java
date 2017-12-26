package com.mobilemovement.bestcoin.view.currencylist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.base.BaseFragment;
import com.mobilemovement.bestcoin.callback.IAdapterItemTouchListener;
import com.mobilemovement.bestcoin.callback.IResponseListener;
import com.mobilemovement.bestcoin.databinding.FragmentCurrencyListBinding;
import com.mobilemovement.bestcoin.utils.OrientationUtils;
import com.mobilemovement.bestcoin.utils.ToastUtils;
import com.mobilemovement.bestcoin.view.currencylist.adapter.CurrencyAdapter;
import com.mobilemovement.bestcoin.view.currencylist.network.FetchCurrencies;

import java.util.Objects;

import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class CurrencyListFragment extends BaseFragment<FragmentCurrencyListBinding> implements IAdapterItemTouchListener {

    CurrencyAdapter currencyAdapter;

    public CurrencyListFragment() { }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        currencyAdapter = new CurrencyAdapter(this);

        initCall();
    }

    @Override
    public int getLayoutManagerId() {
        int configuration = OrientationUtils.detectOrientation(Objects.requireNonNull(getActivity()));

        if (configuration == 1) {
            return GRID_LAYOUT_ID;
        } else {
            return GRID_LAYOUT_LAND_ID;
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_currency_list;
    }

    @Override
    public boolean getHasFixedSize() {
        return true;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return fragmentDataBinding.rvCoinList;
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return currencyAdapter;
    }

    @Override
    public void onTouched(String logoUrl, String marketCurrency, String marketCurrencyLong, boolean isActive) {
        ToastUtils.showInfoMessage(getActivity(), "Selected item is: " + marketCurrencyLong + " " + marketCurrency);
    }

    private void initCall() {
        FetchCurrencies.loadCurrencies(currencyAdapter, new IResponseListener() {
            @Override
            public void onFailure() {
                ToastUtils.showErrorMessage(getActivity(), getString(R.string.error_message));
            }

            @Override
            public void onSuccess() {
            }
        });
    }
}