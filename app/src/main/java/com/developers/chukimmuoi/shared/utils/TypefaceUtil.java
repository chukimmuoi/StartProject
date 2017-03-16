package com.developers.chukimmuoi.shared.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.util.DisplayMetrics;

import java.lang.reflect.Field;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : StartProject
 * Created by chukimmuoi on 3/16/17.
 */

public class TypefaceUtil {
    /**
     * see https://gist.github.com/artem-zinnatullin/7749076
     * <p>
     * Using reflection to override default typeface
     * NOTICE: DO NOT FORGET TO SET TYPEFACE FOR APP THEME AS DEFAULT TYPEFACE WHICH WILL BE OVERRIDDEN
     *
     * @param context                    to work with assets
     * @param defaultFontNameToOverride  for example "monospace", "serif"
     * @param customFontFileNameInAssets file name of the font from assets
     */
    public static void overrideFont(Context context,
                                    String defaultFontNameToOverride,
                                    String customFontFileNameInAssets) {
        try {
            Typeface customFontTypeface
                    = Typeface.createFromAsset(context.getAssets(), customFontFileNameInAssets);

            Field defaultFontTypefaceField
                    = Typeface.class.getDeclaredField(defaultFontNameToOverride);
            defaultFontTypefaceField.setAccessible(true);
            defaultFontTypefaceField.set(null, customFontTypeface);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * see http://stackoverflow.com/questions/6786439/how-to-set-font-scale-in-my-own-android-application
     * <p>
     * Using reflection to override default text size
     *
     * @param context  MainActivity, place it before calling super.setContentView(R.layout.yourLayout)
     * @param textSize for example 0.85f small, 1.0f normal, 1.15f large
     */
    public static void overrideSize(Activity context, float textSize) {
        try {
            Configuration configuration = context.getResources().getConfiguration();
            configuration.fontScale = textSize;

            DisplayMetrics metrics = new DisplayMetrics();
            context.getWindowManager().getDefaultDisplay().getMetrics(metrics);
            metrics.scaledDensity = configuration.fontScale * metrics.density;
            context.getBaseContext().getResources().updateConfiguration(configuration, metrics);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
