package com.mobilemovement.bestcoin.adapter;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by nuhkoca on 9.12.2017.
 */

public class ImageBindingAdapter {

    @BindingAdapter("{bind:logoUrl}")
    public static void loadImage(ImageView imageView, String url) {
        if (!url.equals("")) {
            RequestOptions options = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .skipMemoryCache(false);

            Glide.with(imageView.getContext())
                    .applyDefaultRequestOptions(options)
                    .load(url)
                    .into(imageView);
        }

    }
}