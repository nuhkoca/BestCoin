package com.mobilemovement.bestcoin.bindadapter;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.mobilemovement.bestcoin.bindadapter.module.GlideApp;

import timber.log.Timber;

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
    public static void loadImagesFromAPI(final ImageView imageView, String url, final ProgressBar progressBar) {
        if (!TextUtils.isEmpty(url)) {

            GlideApp.with(imageView.getContext())
                    .asBitmap()
                    .load(Uri.parse(url))
                    .listener(requestListener(progressBar))
                    .into(imageView)
                    .getSize(new SizeReadyCallback() {
                        @Override
                        public void onSizeReady(int width, int height) {
                            Timber.d(width + " " + height);
                        }
                    });
        }
    }

    private static RequestListener<Bitmap> requestListener(final ProgressBar progressBar) {
        return new RequestListener<Bitmap>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }
        };
    }
}