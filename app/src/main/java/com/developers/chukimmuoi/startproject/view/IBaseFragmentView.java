package com.developers.chukimmuoi.startproject.view;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

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
    Fragment findingFragment(@IdRes int layoutId, FragmentManager fragmentManager);

    Fragment findingFragment(@IdRes int layoutId);

    Fragment findingFragment(String tag, FragmentManager fragmentManager);

    Fragment findingFragment(String tag);


    void displayFragment(@IdRes int idLayoutContainer, Fragment fragment, String tag,
                         boolean isSaveCache, @Nullable Bundle bundle,
                         FragmentManager fragmentManager);

    void displayFragment(@IdRes int idLayoutContainer, Fragment fragment, String tag,
                         boolean isSaveCache, @Nullable Bundle bundle);

    void displayFragment(@IdRes int idLayoutContainer, Fragment fragment, String tag,
                         boolean isSaveCache);

    void displayMultiFragment(@IdRes int idLayoutContainer, Fragment fragment, String tag,
                              @Nullable String tagParent, @Nullable Bundle bundle,
                              FragmentManager fragmentManager);

    void displayMultiFragment(@IdRes int idLayoutContainer, Fragment fragment, String tag,
                              @Nullable String tagParent, @Nullable Bundle bundle);

    void displayMultiFragment(@IdRes int idLayoutContainer, Fragment fragment, String tag,
                              @Nullable String tagParent);

    void backStackFragmentHome(FragmentManager fragmentManager);

    void backStackFragmentHome();

    void onBackPressed(FragmentManager fragmentManager);
}
