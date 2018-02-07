package com.mobilemovement.bestcoin.bindadapter.module;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ObjectKey;
import com.mobilemovement.bestcoin.R;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import static com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888;

/**
 * Created by nuhkoca on 1/9/18.
 */

/**
 * Module to handle Glide library
 */

@GlideModule
public class BestCoinAppGlideModule extends AppGlideModule {

    private static final int WIDTH = 96;
    private static final int HEIGHT = 96;

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .build();

        OkHttpUrlLoader.Factory factory = new OkHttpUrlLoader.Factory(client);

        glide.getRegistry().replace(GlideUrl.class, InputStream.class, factory);
    }

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        int memoryCacheSizeBytes = 1024 * 1024 * 20; // 20mb
        builder.setMemoryCache(new LruResourceCache(memoryCacheSizeBytes));
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, memoryCacheSizeBytes));
        builder.setDefaultRequestOptions(requestOptions(context));
        builder.build(context);
    }

    /**
     * Handles lots of features that Glide offers
     *
     * @param context
     * @return RequestOptions
     */

    private static RequestOptions requestOptions(Context context) {
        return new RequestOptions()
                .signature(new ObjectKey(
                        System.currentTimeMillis() / (24 * 60 * 60 * 1000)))
                .override(WIDTH, HEIGHT)
                .centerCrop()
                .encodeFormat(Bitmap.CompressFormat.PNG)
                .encodeQuality(100)
                .fallback(ContextCompat.getDrawable(context, R.drawable.no_image))
                .error(ContextCompat.getDrawable(context, R.drawable.no_image))
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .format(PREFER_ARGB_8888)
                .skipMemoryCache(false);
    }
}
