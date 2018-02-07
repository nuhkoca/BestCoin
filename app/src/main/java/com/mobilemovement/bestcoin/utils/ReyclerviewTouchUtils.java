package com.mobilemovement.bestcoin.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.mobilemovement.bestcoin.callback.IRecyclerviewTouchListener;

/**
 * Created by nuhkoca on 2/7/18.
 */

public class ReyclerviewTouchUtils implements RecyclerView.OnItemTouchListener {

    private GestureDetector mGestureDetector;
    private IRecyclerviewTouchListener mIRecyclerviewTouchListener;

    public ReyclerviewTouchUtils(Context context, final RecyclerView recyclerView, final IRecyclerviewTouchListener clickListener) {
        this.mIRecyclerviewTouchListener = clickListener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && clickListener != null) {
                    clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && mIRecyclerviewTouchListener != null && mGestureDetector.onTouchEvent(e)) {
            mIRecyclerviewTouchListener.onClick(child, rv.getChildAdapterPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}