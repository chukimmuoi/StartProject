package com.developers.chukimmuoi.shared.ui.swipe;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

import com.developers.chukimmuoi.startproject.R;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : StartProject
 * Created by chukimmuoi on 4/23/17.
 */

public class BaseSwipeRefreshLayout extends SwipeRefreshLayout {

    public BaseSwipeRefreshLayout(Context context) {
        super(context);
        constructor();
    }

    public BaseSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        constructor();
    }

    private void constructor() {
        setColorSchemeResources(R.color.colorSwipeBlue, R.color.colorSwipeGreen,
                R.color.colorSwipeOrange, R.color.colorSwipeRed);
    }
}
