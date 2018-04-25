package com.sjw.utils.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by androidS on 2018/4/25.
 */

public class SPUtils {
    private static String NAME = "config";
    private static SharedPreferences mSp;

    public static void setNAME(String name) {
        NAME = name;
    }
    public static String getNAME(){
        return NAME;
    }

    private static SharedPreferences getSharedPreferences(@NonNull Context context) {
        if (mSp == null) {
            mSp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        return mSp;
    }

    public static void putString(@NonNull Context context, String key, String path) {
        getSharedPreferences(context).edit().putString(key, path).commit();
    }

    @Nullable
    public static String getString(@NonNull Context context, String key, String defValue) {
        return getSharedPreferences(context).getString(key, defValue);
    }
    public static int getInt(@NonNull Context context, String key, int defValue) {
        return getSharedPreferences(context).getInt(key, defValue);
    }

    public static void putInt(@NonNull Context context, String key, int value) {
        getSharedPreferences(context).edit().putInt(key,value).commit();
    }
    public static long getLong(@NonNull Context context, String key, long defValue) {
        return getSharedPreferences(context).getLong(key, defValue);
    }

    public static void putLong(@NonNull Context context, String key, long value) {
        getSharedPreferences(context).edit().putLong(key,value).commit();
    }
}
