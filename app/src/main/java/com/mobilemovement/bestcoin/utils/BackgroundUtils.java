package com.mobilemovement.bestcoin.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.mobilemovement.bestcoin.bindadapter.module.GlideApp;

/**
 * Created by nuhkoca on 17.12.2017.
 */

public class BackgroundUtils {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 300;

    public static void changeBackgroundImage(final ImageView imageView, int imageId, Context context) {
        BitmapTransitionOptions bitmapTransition = new BitmapTransitionOptions()
                .crossFade(100);

        GlideApp.with(context)
                .asBitmap()
                .load(imageId)
                .transition(bitmapTransition)
                .apply(requestOptions())
                .into(new ImageViewTarget<Bitmap>(imageView) {
                    @Override
                    protected void setResource(@Nullable Bitmap resource) {
                        imageView.setImageBitmap(resource);
                    }
                });
    }

    private static RequestOptions requestOptions() {
        return new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .override(WIDTH, HEIGHT);
    }
}
