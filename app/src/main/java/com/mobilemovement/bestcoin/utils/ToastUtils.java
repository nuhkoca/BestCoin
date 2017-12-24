package com.mobilemovement.bestcoin.utils;

import android.content.Context;
import android.widget.Toast;
import es.dmoral.toasty.Toasty;

public class ToastUtils {
    public static void showErrorMessage(Context context, CharSequence message) {
        Toasty.error(context, message, Toast.LENGTH_LONG, true).show();
    }

    public static void showErrorMessage(Context context, int resId) {
        Toasty.error(context, context.getResources().getText(resId), Toast.LENGTH_LONG, true).show();
    }

    public static void showSuccessMessage(Context context, CharSequence message) {
        Toasty.success(context, message).show();
    }

    public static void showSuccessMessage(Context context, int resId) {
        Toasty.success(context, context.getResources().getText(resId), Toast.LENGTH_LONG, true).show();
    }

    public static void showWarningMessage(Context context, CharSequence message) {
        Toasty.warning(context, message).show();
    }

    public static void showWarningMessage(Context context, int resId) {
        Toasty.warning(context, context.getResources().getText(resId), Toast.LENGTH_LONG, true).show();
    }

    public static void showInfoMessage(Context context, CharSequence message) {
        Toasty.info(context, message).show();
    }

    public static void showInfoMessage(Context context, int resId) {
        Toasty.info(context, String.valueOf(resId), Toast.LENGTH_LONG, true).show();
    }
}