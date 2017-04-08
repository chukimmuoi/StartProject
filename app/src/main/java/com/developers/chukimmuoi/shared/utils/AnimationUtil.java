package com.developers.chukimmuoi.shared.utils;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.widget.TextView;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : StartProject
 * Created by chukimmuoi on 4/8/17.
 */

public class AnimationUtil {
    /**
     * Set percent text view
     *
     * @param initialValue start value
     * @param finalValue   end value
     * @param textView     UI
     * @param time         mi li seconds
     * @see {http://stackoverflow.com/a/24389011/3399234}
     */
    public static void animateTextView(int initialValue, int finalValue,
                                        final TextView textView, long time) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setObjectValues(initialValue, finalValue);
        valueAnimator.addUpdateListener(animation ->
                textView.setText(String.valueOf(animation.getAnimatedValue())));

        valueAnimator.setEvaluator(new TypeEvaluator<Integer>() {
            public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
                return Math.round(startValue + (endValue - startValue) * fraction);
            }
        });

        valueAnimator.setDuration(time);
        valueAnimator.start();
    }
}
