package com.mobilemovement.bestcoin.view.currencylist.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.databinding.CurrencyDetailsItemListBinding;

import java.util.Objects;

/**
 * Created by nuhkoca on 2/7/18.
 */

public class CurrencyDetailAdapter extends RecyclerView.Adapter<CurrencyDetailAdapter.ViewHolder> {

    private Bundle args;

    public CurrencyDetailAdapter(Bundle args) {
        this.args = args;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        CurrencyDetailsItemListBinding currencyDetailsItemListBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.currency_details_item_list,
                parent,
                false);

        return new ViewHolder(Objects.requireNonNull(currencyDetailsItemListBinding).getRoot());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindViews();
    }

    @Override
    public int getItemCount() {
        return args.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private CurrencyDetailsItemListBinding mCurrencyDetailsItemListBinding;

        ViewHolder(View itemView) {
            super(itemView);

            mCurrencyDetailsItemListBinding = DataBindingUtil.bind(itemView);
        }

        void bindViews() {
            mCurrencyDetailsItemListBinding.tvCurrencyDetailLabel.setText("Market Currency");
            mCurrencyDetailsItemListBinding.tvCurrencyDetail.setText(args.getString("market-name"));
            mCurrencyDetailsItemListBinding.executePendingBindings();
        }
    }
}
