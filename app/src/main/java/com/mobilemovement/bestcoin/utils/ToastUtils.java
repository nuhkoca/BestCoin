package com.mobilemovement.bestcoin.utils;

import android.content.Context;
import es.dmoral.toasty.Toasty;

public class ToastUtils {
    public static void showErrorMessage(Context context, CharSequence message) {
        Toasty.error(context, message).show();
    }

    public static void showSuccessMessage(Context context, CharSequence message) {
        Toasty.success(context, message).show();
    }

    public static void showWarningMessage(Context context, CharSequence message) {
        Toasty.warning(context, message).show();
    }

    public static void showInfoMessage(Context context, CharSequence message) {
        Toasty.info(context, message).show();
    }
}