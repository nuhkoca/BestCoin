package com.mobilemovement.bestcoin.view.currencylist;

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
import com.mobilemovement.bestcoin.callback.IAdapterItemTouchListener;
import com.mobilemovement.bestcoin.callback.IResponseListener;
import com.mobilemovement.bestcoin.databinding.FragmentCurrencyListBinding;
import com.mobilemovement.bestcoin.utils.OrientationUtils;
import com.mobilemovement.bestcoin.utils.ToastUtils;
import com.mobilemovement.bestcoin.view.currencylist.adapter.CurrencyAdapter;
import com.mobilemovement.bestcoin.view.currencylist.network.FetchCurrencies;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class CurrencyListFragment extends BaseFragment<FragmentCurrencyListBinding> implements IAdapterItemTouchListener {

    public CurrencyListFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_currency_list, container, false);

        return Objects.requireNonNull(fragmentDataBinding).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        CurrencyAdapter currencyAdapter = new CurrencyAdapter(this);

        initUI(fragmentDataBinding.rvCoinList,
                currencyAdapter);

        FetchCurrencies.loadCurrencies(currencyAdapter, new IResponseListener() {
            @Override
            public void onFailed() {
                ToastUtils.showErrorMessage(getActivity(), getString(R.string.error_message));
            }
        });
    }

    @Override
    public int getLayoutId() {
        int configuration = OrientationUtils.detectOrientation(Objects.requireNonNull(getActivity()));

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

    @Override
    public void onTouched(String logoUrl, String marketCurrency, String marketCurrencyLong, boolean isActive) {
        ToastUtils.showInfoMessage(getActivity(), "Selected item is: " + marketCurrencyLong + " " + marketCurrency);
    }
}