package com.developers.chukimmuoi.shared.ui.recycler.view;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : StartProject
 * Created by chukimmuoi on 4/8/17.
 */

public interface IBaseRecyclerView {

    void initLayoutManager(int typeLayout, int spanCount, boolean isHorizontal, boolean isReverse);

    void initLayoutManager(int typeLayout, int spanCount, boolean isHorizontal);

    void initLayoutManager(int typeLayout, int spanCount);

    void initLinearLayoutManager();

    void initGridLayoutManager(int spanCount);

    void initStaggeredGridLayoutManager(int spanCount);

    void setLinearSnapHelper(int typeGravity, boolean isSnapPager);

    void setLinearSnapHelper(int typeGravity);
}
