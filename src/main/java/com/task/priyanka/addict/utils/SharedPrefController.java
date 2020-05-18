package com.task.priyanka.addict.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefController {
    private final SharedPreferences preferences;
    private static final String PREF_FILE_NAME = "android.content.SharedPreferences";
    final static Object lock = new Object();
    static SharedPrefController sharedPreferencesController;

    public Context context;

    public final static String PREFS_NAME = "package_prefs";



    private SharedPrefController(Context context) {
        preferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        this.context = context;
    }

    public static SharedPrefController getSharedPreferencesController(Context context) {
        synchronized (lock) {
            if (sharedPreferencesController == null) {
                sharedPreferencesController = new SharedPrefController(context);
            }
            return sharedPreferencesController;
        }
    }
    public void removeFromSharedPreferences(Context mContext, String key) {
        if (mContext != null) {
            if (preferences != null)
                preferences.edit().remove(key).commit();
        }
    }

    public void setString(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getStringValue(String key) {
        return preferences.getString(key, null);
    }

    public void setLongValue(String key, long value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public long getLongValue(String key) {
        return preferences.getLong(key, 0);
    }

    public void setInt(String key, int value) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getInt(String key) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getInt(key, 0);
    }


}