package com.developers.chukimmuoi.shared.utils;

import android.content.Context;
import android.graphics.Typeface;

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
}
