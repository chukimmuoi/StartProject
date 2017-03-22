package com.developers.chukimmuoi.startproject.view;

import android.support.v4.app.Fragment;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : StartProject
 * Created by chukimmuoi on 3/22/17.
 */

public interface IBaseFragmentView {
    Fragment findingFragment(int layoutId);

    Fragment findingFragment(String tag);
}
