package com.developers.chukimmuoi.startproject.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : StartProject
 * Created by chukimmuoi on 3/18/17.
 */

public class SettingManager {
    private static final String TAG = SettingManager.class.getSimpleName();

    private static SettingManager mOurInstance;

    private SharedPreferences mSharedPreferences;

    private SharedPreferences.Editor mEditor;

    public SettingManager(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        mEditor = mSharedPreferences.edit();
    }

    public static SettingManager getInstance(Context context) {
        if (mOurInstance == null) {
            synchronized (SettingManager.class) {
                mOurInstance = new SettingManager(context);
            }
        }
        return mOurInstance;
    }

    private void save(String key, Object values) {
        if (mEditor != null) {
            String value = String.valueOf(values);

            if (values instanceof String) {
                mEditor.putString(key, value);
            }
            else if (values instanceof Boolean) {
                mEditor.putBoolean(key, Boolean.parseBoolean(value));
            }
            else if (values instanceof Integer) {
                mEditor.putInt(key, Integer.parseInt(value));
            }
            else if (values instanceof Float) {
                mEditor.putFloat(key, Float.parseFloat(value));
            }
            else if (values instanceof Long) {
                mEditor.putLong(key, Long.parseLong(value));
            }

            mEditor.commit();
        }
    }

    private Object get(String key, Object defaultValues) {
        if (mSharedPreferences != null) {
            String defaultValue = String.valueOf(defaultValues);

            if (defaultValues instanceof String) {
                return mSharedPreferences.getString(key, defaultValue);
            }
            else if (defaultValues instanceof Boolean) {
                return mSharedPreferences.getBoolean(key, Boolean.parseBoolean(defaultValue));
            }
            else if (defaultValues instanceof Integer) {
                return mSharedPreferences.getInt(key, Integer.parseInt(defaultValue));
            }
            else if (defaultValues instanceof Float) {
                return mSharedPreferences.getFloat(key, Float.parseFloat(defaultValue));
            }
            else if (defaultValues instanceof Long) {
                return mSharedPreferences.getLong(key, Long.parseLong(defaultValue));
            }
        }
        return null;
    }

    private void clearCache() {
        if (mEditor != null) {
            mEditor.clear();
            mEditor.commit();
        }
    }

    private void onDestroy() {
        if (mOurInstance != null) {
            mEditor = null;
            mSharedPreferences = null;

            mOurInstance = null;
        }
    }
}
