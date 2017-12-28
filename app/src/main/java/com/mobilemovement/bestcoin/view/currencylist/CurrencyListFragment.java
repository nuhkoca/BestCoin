package com.mobilemovement.bestcoin.view.currencylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.base.BaseFragment;
import com.mobilemovement.bestcoin.callback.IAdapterItemTouchListener;
import com.mobilemovement.bestcoin.callback.IResponseListener;
import com.mobilemovement.bestcoin.databinding.FragmentCurrencyListBinding;
import com.mobilemovement.bestcoin.model.sharedmodel.Result;
import com.mobilemovement.bestcoin.utils.OrientationUtils;
import com.mobilemovement.bestcoin.utils.ToastUtils;
import com.mobilemovement.bestcoin.view.currencylist.adapter.CurrencyAdapter;
import com.mobilemovement.bestcoin.view.currencylist.network.FetchCurrencies;
import com.mobilemovement.bestcoin.view.currencylist.activity.CurrencyDetailsActivity;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class CurrencyListFragment extends BaseFragment<FragmentCurrencyListBinding> implements IAdapterItemTouchListener {

    private CurrencyAdapter mCurrencyAdapter;

    public static CurrencyListFragment newInstance() {
        return new CurrencyListFragment();
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
        mCurrencyAdapter = new CurrencyAdapter(this);

        return mCurrencyAdapter;
    }

    @Override
    protected void initUI() {
        initCall();
    }

    private void initCall() {
        FetchCurrencies.loadCurrencies(mCurrencyAdapter, new IResponseListener() {
            @Override
            public void onFailure() {
                ToastUtils.showErrorMessage(getActivity(), getString(R.string.no_connection_error_message));
            }

            @Override
            public void onSuccess() {
                mPbLoading.setVisibility(View.GONE);
                mTvLoading.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onCurrencyTouch(Result result, ImageView imageView) {
        Intent detailsIntent = new Intent(getActivity(), CurrencyDetailsActivity.class);
        detailsIntent.putExtra("result", result.getLogoUrl());
        detailsIntent.putExtra("transition-name", ViewCompat.getTransitionName(imageView));

        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                Objects.requireNonNull(getActivity()),
                imageView,
                ViewCompat.getTransitionName(imageView));
        startActivity(detailsIntent, optionsCompat.toBundle());
    }
}