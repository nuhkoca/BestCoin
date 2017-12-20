package com.mobilemovement.bestcoin.utils;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Created by nuhkoca on 17.12.2017.
 */

public class CollapsingToolbarLayoutBackgroundUtils {
    public static void changeBackground(ImageView imageView, int imageId, Context context) {
        DrawableTransitionOptions drawableTransitionOptions = new DrawableTransitionOptions()
                .crossFade(100);

        Glide.with(context)
                .load(imageId)
                .transition(drawableTransitionOptions)
                .into(imageView);
    }
}
