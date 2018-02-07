package com.mobilemovement.bestcoin.view.currencylist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.base.BaseFragment;
import com.mobilemovement.bestcoin.callback.IRecyclerviewTouchListener;
import com.mobilemovement.bestcoin.databinding.FragmentCurrencyDetailsHolderBinding;
import com.mobilemovement.bestcoin.utils.ItemDividerUtils;
import com.mobilemovement.bestcoin.utils.ReyclerviewTouchUtils;
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
    protected RecyclerView getRecyclerView() {
        return fragmentDataBinding.rvCurrencyItemDetails;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mCurrencyDetailAdapter;
    }

    @Override
    protected void initUI() {
    }

    @Override
    protected boolean performOrientationType() {
        return false;
    }

    @Override
    protected void addExtraToRecyclerview() {
        fragmentDataBinding.rvCurrencyItemDetails.setHasFixedSize(true);
        fragmentDataBinding.rvCurrencyItemDetails.setNestedScrollingEnabled(false);
        fragmentDataBinding.rvCurrencyItemDetails.addItemDecoration(new ItemDividerUtils(getActivity(), LinearLayoutManager.VERTICAL, 16));

        fragmentDataBinding.rvCurrencyItemDetails.addOnItemTouchListener(new ReyclerviewTouchUtils(getActivity(), fragmentDataBinding.rvCurrencyItemDetails, new IRecyclerviewTouchListener() {
            @Override
            public void onClick(View view, int position) {
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
    }
}
