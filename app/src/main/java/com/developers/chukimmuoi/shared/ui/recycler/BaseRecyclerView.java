package com.developers.chukimmuoi.shared.ui.recycler;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

import com.developers.chukimmuoi.shared.ui.recycler.listener.EndlessRecyclerViewScrollListener;
import com.developers.chukimmuoi.shared.ui.recycler.view.IBaseRecyclerView;

import java.util.List;

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

    private final static int SPACES_ITEM = 16;

    private Context mContext;

    private int mTypeLayout = 0xa;

    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager mGridLayoutManager;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    private EndlessRecyclerViewScrollListener mEndlessScrollListener;
    private OnEndlessScrolling mOnEndlessScrolling;

    private ItemDecoration mItemDecoration;

    public BaseRecyclerView(Context context) {
        super(context);

        constructor(context);
    }

    public BaseRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        constructor(context);
    }

    public BaseRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        constructor(context);
    }

    private void constructor(Context context) {
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
        mTypeLayout = typeLayout;
        switch (typeLayout) {
            case LINEAR_LAYOUT:
                mLinearLayoutManager = new LinearLayoutManager(mContext, isHorizontal
                        ? LinearLayoutManager.HORIZONTAL
                        : LinearLayoutManager.VERTICAL, isReverse);

                mItemDecoration = new SpacesItemDecoration
                        .SpacesItemDecorationBuilder(SPACES_ITEM)
                        .setLinearLayoutType(isHorizontal
                                ? DividerItemDecoration.HORIZONTAL
                                : DividerItemDecoration.VERTICAL)
                        .build();

                setLayoutManager(mLinearLayoutManager);
                break;
            case GRID_LAYOUT:
                if (spanCount > 0) {
                    mGridLayoutManager = new GridLayoutManager(mContext, spanCount, isHorizontal
                            ? GridLayoutManager.HORIZONTAL
                            : GridLayoutManager.VERTICAL, isReverse);

                    //TODO: Load more full span (GridLayoutManager).
                    mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                        @Override
                        public int getSpanSize(int position) {
                            BaseRecyclerAdapter adapter = (BaseRecyclerAdapter) getAdapter();
                            switch (adapter.getItemViewType(position)) {
                                case BaseRecyclerAdapter.VIEW_ITEM:
                                    return 1;
                                case BaseRecyclerAdapter.VIEW_PROGRESS:
                                    return spanCount;
                                default:
                                    return 0;
                            }
                        }
                    });

                    mItemDecoration = new SpacesItemDecoration
                            .SpacesItemDecorationBuilder(SPACES_ITEM)
                            .setSpanCount(spanCount)
                            .build();

                    setLayoutManager(mGridLayoutManager);
                }
                break;
            case STAGGERED_GRID_LAYOUT:
                if (spanCount > 0) {
                    mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(spanCount, isHorizontal
                            ? StaggeredGridLayoutManager.HORIZONTAL
                            : StaggeredGridLayoutManager.VERTICAL);

                    mItemDecoration = new SpacesItemDecoration
                            .SpacesItemDecorationBuilder(SPACES_ITEM)
                            .setSpanCount(spanCount)
                            .build();

                    setLayoutManager(mStaggeredGridLayoutManager);
                }
                break;
        }

        addItemDecoration(mItemDecoration);
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

    public interface OnEndlessScrolling {
        /**
         * Load new data
         *
         * @see {http://stackoverflow.com/questions/39445330/cannot-call-notifyiteminserted-method-in-a-scroll-callback-recyclerview-v724-2}
         * <p>
         * view.post(() -> mAdapter.insertItem(positionStart, insertList));
         * {@link BaseRecyclerAdapter#insertItem(int, List)}
         */
        void loadNextPage(int page, int totalItemsCount, RecyclerView view);

        /**
         * Clear all data ---> new action.
         * <p>
         * mList.clear();
         * mAdapter.notifyDataSetChanged(); {@link BaseRecyclerAdapter#reloadAll()}
         * mEndlessScrollListener.resetState(); {@link #resetStateEndless()}
         */
        void resetEndless();
    }

    public boolean resetStateEndless() {
        if (mEndlessScrollListener != null) {
            mEndlessScrollListener.resetState();
            return true;
        }
        return false;
    }

    public void setOnEndlessScrolling(OnEndlessScrolling onEndlessScrolling) {
        this.mOnEndlessScrolling = onEndlessScrolling;

        switch (mTypeLayout) {
            case LINEAR_LAYOUT:
                mEndlessScrollListener = new EndlessRecyclerViewScrollListener(mLinearLayoutManager) {
                    @Override
                    public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                        actionLoadMore(page, totalItemsCount, view);
                    }
                };
                break;
            case GRID_LAYOUT:
                mEndlessScrollListener = new EndlessRecyclerViewScrollListener(mGridLayoutManager) {
                    @Override
                    public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                        actionLoadMore(page, totalItemsCount, view);
                    }
                };
                break;
            case STAGGERED_GRID_LAYOUT:
                mEndlessScrollListener = new EndlessRecyclerViewScrollListener(mStaggeredGridLayoutManager) {
                    @Override
                    public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                        actionLoadMore(page, totalItemsCount, view);
                    }
                };
                break;
        }

        if (mEndlessScrollListener != null) {
            addOnScrollListener(mEndlessScrollListener);
        }
    }

    private void actionLoadMore(int page, int totalItemsCount, RecyclerView view) {
        if (mOnEndlessScrolling != null) {
            mOnEndlessScrolling.loadNextPage(page, totalItemsCount, view);
        }
    }
}
