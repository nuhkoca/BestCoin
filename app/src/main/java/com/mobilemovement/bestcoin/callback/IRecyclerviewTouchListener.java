package com.mobilemovement.bestcoin.callback;

import android.view.View;

/**
 * Created by nuhkoca on 2/7/18.
 */

public interface IRecyclerviewTouchListener {
    void onClick(View view, int position);
    void onLongClick(View view, int position);
}