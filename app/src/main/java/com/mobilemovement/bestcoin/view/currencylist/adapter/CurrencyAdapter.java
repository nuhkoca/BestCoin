package com.mobilemovement.bestcoin.view.currencylist.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.databinding.library.baseAdapters.BR;
import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.callback.IAdapterItemTouchListener;
import com.mobilemovement.bestcoin.databinding.CurrencyListItemCardViewBinding;
import com.mobilemovement.bestcoin.model.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {

    private List<Result> mResults;
    final private IAdapterItemTouchListener mAdapterItemTouchListener;

    public CurrencyAdapter(IAdapterItemTouchListener iAdapterItemTouchListener) {
        mResults = new ArrayList<>();

        mAdapterItemTouchListener = iAdapterItemTouchListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        CurrencyListItemCardViewBinding currencyListItemCardViewBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.currency_list_item_card_view,
                parent,
                false);

        return new ViewHolder(Objects.requireNonNull(currencyListItemCardViewBinding).getRoot());
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

        private CurrencyListItemCardViewBinding currencyListItemCardViewBinding;

        ViewHolder(View itemView) {
            super(itemView);
            currencyListItemCardViewBinding = DataBindingUtil.bind(itemView);
        }

        void bindViews(Result result) {
            currencyListItemCardViewBinding.setVariable(BR.result, result);
            currencyListItemCardViewBinding.setVariable(BR.touchListener, mAdapterItemTouchListener);
            currencyListItemCardViewBinding.executePendingBindings();
        }
    }
}