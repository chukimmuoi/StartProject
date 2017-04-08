package com.developers.chukimmuoi.shared.ui.recycler;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

import com.developers.chukimmuoi.shared.ui.recycler.view.IBaseRecyclerView;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : StartProject
 * Created by chukimmuoi on 4/2/17.
 */

public class BaseRecyclerView extends RecyclerView implements IBaseRecyclerView {

    private final static String TAG = BaseRecyclerView.class.getSimpleName();

    public final static int LINEAR_LAYOUT = 0xa;
    public final static int GRID_LAYOUT = 0xb;
    public final static int STAGGERED_GRID_LAYOUT = 0xc;

    private Context mContext;

    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager mGridLayoutManager;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    public BaseRecyclerView(Context context) {
        super(context);

        mContext = context;
    }

    public BaseRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
    }

    public BaseRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mContext = context;
    }

    @Override
    public void setLayoutManager(LayoutManager layout) {
        super.setLayoutManager(layout);
    }

    /**
     * Set layout manager
     *
     * @param typeLayout   {@link #LINEAR_LAYOUT}, {@link #GRID_LAYOUT}, {@link #STAGGERED_GRID_LAYOUT}
     * @param spanCount    use when typeLayout = {@link #GRID_LAYOUT} or {@link #STAGGERED_GRID_LAYOUT}
     * @param isHorizontal is "true"  ---> Chieu ngang.
     *                     is "false" ---> Chieu doc(*).
     * @param isReverse    is "true"  ---> Dao huong scroll.(right -> left & top -> bottom).
     *                     is "false" ---> normal(*).
     */
    @Override
    public void initLayoutManager(int typeLayout, int spanCount,
                                  boolean isHorizontal, boolean isReverse) {
        switch (typeLayout) {
            case LINEAR_LAYOUT:
                mLinearLayoutManager = new LinearLayoutManager(mContext, isHorizontal
                        ? LinearLayoutManager.HORIZONTAL
                        : LinearLayoutManager.VERTICAL, isReverse);

                setLayoutManager(mLinearLayoutManager);
                break;
            case GRID_LAYOUT:
                if (spanCount > 0) {
                    mGridLayoutManager = new GridLayoutManager(mContext, spanCount, isHorizontal
                            ? GridLayoutManager.HORIZONTAL
                            : GridLayoutManager.VERTICAL, isReverse);

                    setLayoutManager(mGridLayoutManager);
                }
                break;
            case STAGGERED_GRID_LAYOUT:
                if (spanCount > 0) {
                    mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(spanCount, isHorizontal
                            ? StaggeredGridLayoutManager.HORIZONTAL
                            : StaggeredGridLayoutManager.VERTICAL);

                    setLayoutManager(mStaggeredGridLayoutManager);
                }
                break;
        }
    }

    @Override
    public void initLayoutManager(int typeLayout, int spanCount, boolean isHorizontal) {
        initLayoutManager(typeLayout, spanCount, isHorizontal, false);
    }

    @Override
    public void initLayoutManager(int typeLayout, int spanCount) {
        initLayoutManager(typeLayout, spanCount, false);
    }

    @Override
    public void initLinearLayoutManager() {
        initLayoutManager(LINEAR_LAYOUT, 0);
    }

    @Override
    public void initGridLayoutManager(int spanCount) {
        initLayoutManager(GRID_LAYOUT, spanCount);
    }

    @Override
    public void initStaggeredGridLayoutManager(int spanCount) {
        initLayoutManager(STAGGERED_GRID_LAYOUT, spanCount);
    }

    @Override
    public void addOnScrollListener(OnScrollListener listener) {
        super.addOnScrollListener(listener);
    }
}
