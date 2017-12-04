package com.mobilemovement.bestcoin.coinlist.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.coinlist.model.CoinListDataModel;
import com.mobilemovement.bestcoin.databinding.CoinListItemCardViewBinding;

import java.util.List;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public class CoinListAdapter extends RecyclerView.Adapter<CoinListAdapter.ViewHolder> {

    private List<CoinListDataModel> mCoinListDataModels;
    private Context mContext;

    public CoinListAdapter(List<CoinListDataModel> mCoinListDataModels, Context mContext) {
        this.mCoinListDataModels = mCoinListDataModels;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        CoinListItemCardViewBinding coinListItemCardViewBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.coin_list_item_card_view,
                parent,
                false);

        return new ViewHolder(coinListItemCardViewBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CoinListDataModel coinListDataModel = mCoinListDataModels.get(position);

        holder.bindView(coinListDataModel);
    }

    @Override
    public int getItemCount() {
        return mCoinListDataModels.size();
    }

    public void updateRecyclerview(List<CoinListDataModel> coinListDataModel) {
        mCoinListDataModels = coinListDataModel;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private CoinListItemCardViewBinding coinListItemCardViewBinding;

        ViewHolder(View itemView) {
            super(itemView);
            coinListItemCardViewBinding = DataBindingUtil.bind(itemView);
        }

        void bindView(CoinListDataModel coinListDataModel) {
            CoinListDataModel getList = coinListItemCardViewBinding.getCoinlistmodel();

            getList.setName(coinListDataModel.getName());
        }
    }
}