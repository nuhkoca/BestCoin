package com.mobilemovement.bestcoin.coinlist.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.coinlist.model.Result;
import com.mobilemovement.bestcoin.databinding.CoinListItemCardViewBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {

    private List<Result> mResults;

    public CurrencyAdapter() {
        mResults = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        CoinListItemCardViewBinding coinListItemCardViewBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.coin_list_item_card_view,
                parent,
                false);

        return new ViewHolder(coinListItemCardViewBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result result = mResults.get(position);

        holder.bindViews(result);
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    public void swapData(List<Result> result) {
        mResults = result;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private CoinListItemCardViewBinding coinListItemCardViewBinding;

        ViewHolder(View itemView) {
            super(itemView);
            coinListItemCardViewBinding = DataBindingUtil.bind(itemView);
        }

        void bindViews(Result result) {
            coinListItemCardViewBinding.setResult(result);
            coinListItemCardViewBinding.executePendingBindings();
        }
    }
}