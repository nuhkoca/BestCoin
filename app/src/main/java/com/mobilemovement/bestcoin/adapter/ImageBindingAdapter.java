package com.mobilemovement.bestcoin.adapter;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by nuhkoca on 9.12.2017.
 */

public class ImageBindingAdapter {

    /**
    *  A value for binding image over URL {@param logoUrl
    */

    @BindingAdapter("logoUrl")
    public static void loadImage(ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            RequestOptions options = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .skipMemoryCache(false);

            Glide.with(imageView.getContext())
                    .applyDefaultRequestOptions(options)
                    .load(url)
                    .into(imageView);
        }

    }
}