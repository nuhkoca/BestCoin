package com.mobilemovement.bestcoin.adapter;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
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
import com.mobilemovement.bestcoin.R;
import timber.log.Timber;

/**
 * Created by nuhkoca on 9.12.2017.
 */

public class ImageBindingAdapter {

    private static final int WIDTH = 120;
    private static final int HEIGHT = 140;

    /**
    *  A value for binding image over URL {@param logoUrl
    *  An ImageView to bind image {@param imageView
    *  A Url to get an image {@param url
    */

    @BindingAdapter({"logoUrl", "progressBar"})
    public static void loadImagesFromAPI(ImageView imageView, String url, final ProgressBar progressBar) {
        if (!TextUtils.isEmpty(url)) {
            Glide.with(imageView.getContext())
                    .applyDefaultRequestOptions(requestOptions(imageView))
                    .load(url)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            Timber.d("An error occured while loading the image");
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

    private static RequestOptions requestOptions(ImageView imageView) {
        return new RequestOptions()
                .override(WIDTH, HEIGHT)
                .centerCrop()
                .error(ContextCompat.getDrawable(imageView.getContext(), R.drawable.no_image))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(false);
    }
}