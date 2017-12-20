package com.mobilemovement.bestcoin.adapter;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

/**
 * Created by nuhkoca on 9.12.2017.
 */

public class ImageBindingAdapter {

    /**
    *  A value for binding image over URL {@param logoUrl
    *  An ImageView to bind image {@param imageView
    *  A Url to get an image {@param url
    */

    @BindingAdapter({"logoUrl", "progressBar"})
    public static void loadImagesFromAPI(ImageView imageView, String url, final ProgressBar progressBar) {
        if (!TextUtils.isEmpty(url)) {
            RequestOptions options = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .skipMemoryCache(false);

            Glide.with(imageView.getContext())
                    .applyDefaultRequestOptions(options)
                    .load(url)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            progressBar.setVisibility(View.GONE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            progressBar.setVisibility(View.GONE);
                            return false;
                        }
                    }).into(imageView);
        }
    }
}