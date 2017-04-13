package com.developers.chukimmuoi.shared.ui.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developers.chukimmuoi.shared.ui.progress.CircleProgress;
import com.developers.chukimmuoi.shared.ui.recycler.model.LoadMoreObject;
import com.developers.chukimmuoi.shared.ui.recycler.view.IBaseRecyclerAdapter;
import com.developers.chukimmuoi.startproject.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : StartProject
 * Created by chukimmuoi on 3/30/17.
 */

public abstract class BaseRecyclerAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH>
        implements IBaseRecyclerAdapter {

    private static String TAG = BaseRecyclerAdapter.class.getSimpleName();

    private static final int VIEW_ITEM = 0x1;

    private static final int VIEW_PROGRESS = 0x2;

    protected Context mContext;

    private BaseRecyclerView mRecyclerView;

    protected List<? super Object> mList;

    public BaseRecyclerAdapter(Context context, BaseRecyclerView recyclerView, List<? super Object> list) {
        this.mContext = context;
        this.mRecyclerView = recyclerView;
        this.mList = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        VH viewHolder = null;

        if (viewType == VIEW_PROGRESS) {
            View view = inflater.inflate(R.layout.item_circle_progress, parent, false);

            viewHolder = (VH) new ProgressViewHolder(view);
        } else if (viewType == VIEW_ITEM) {
            View view = setLayout(inflater, parent);

            viewHolder = createViewHolder(view);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if (getItemViewType(position) == VIEW_ITEM) {
            displayItem(holder, position);
        } else if (getItemViewType(position) == VIEW_PROGRESS) {
            ((ProgressViewHolder) holder).progressCircle.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (mList != null) {
            if (mList.get(position) instanceof LoadMoreObject) {
                return VIEW_PROGRESS;
            } else {
                return VIEW_ITEM;
            }
        }
        return super.getItemViewType(position);
    }

    public static class ProgressViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.progress_circle)
        CircleProgress progressCircle;

        public ProgressViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

    protected abstract View setLayout(LayoutInflater inflater, ViewGroup parent);

    protected abstract VH createViewHolder(View view);

    protected abstract void displayItem(VH viewHolder, int position);

    /**
     * Add item
     *
     * @param position getItemCount or mList.size()
     * @param object   new object
     * @param isScroll
     */
    @Override
    public void insertItem(int position, Object object, boolean isScroll) {
        if (position >= 0 && object != null) {
            mList.add(position, object);

            mRecyclerView.post(() -> notifyItemInserted(position));

            if (isScroll) {
                mRecyclerView.scrollToPosition(position);
            }
        }
    }

    @Override
    public void insertItem(int position, Object object) {
        insertItem(position, object, false);
    }

    /**
     * Add list item
     *
     * @param positionStart getItemCount or mList.size()
     * @param insertList    list object
     * @param isScroll
     */
    @Override
    public void insertItem(int positionStart, List<? super Object> insertList, boolean isScroll) {
        if (positionStart >= 0 && insertList != null) {
            int itemCount = insertList.size();
            if (itemCount > 0) {
                mList.addAll(positionStart, insertList);

                mRecyclerView.post(() -> notifyItemRangeInserted(positionStart, itemCount));

                if (isScroll) {
                    mRecyclerView.scrollToPosition(positionStart);
                }
            }
        }
    }

    @Override
    public void insertItem(int positionStart, List<? super Object> insertList) {
        insertItem(positionStart, insertList, false);
    }

    /**
     * Update item
     *
     * @param position all in 0 <= position < getItemCount or mList.size()
     * @param isScroll
     */
    @Override
    public void updateItem(int position, boolean isScroll) {
        if (position >= 0 && position < getItemCount()) {
            mRecyclerView.post(() -> notifyItemChanged(position));

            if (isScroll) {
                mRecyclerView.scrollToPosition(position);
            }
        }
    }

    @Override
    public void updateItem(int position) {
        updateItem(position, false);
    }

    /**
     * Update list item
     *
     * @param positionStart all in 0 <= position < getItemCount or mList.size()
     * @param itemCount     size of list update. eg: list.size()
     * @param isScroll
     */
    @Override
    public void updateItem(int positionStart, int itemCount, boolean isScroll) {
        if (positionStart >= 0 && itemCount > 0 && (positionStart + itemCount) < getItemCount()) {
            mRecyclerView.post(() -> notifyItemRangeChanged(positionStart, itemCount));

            if (isScroll) {
                mRecyclerView.scrollToPosition(positionStart);
            }
        }
    }

    @Override
    public void updateItem(int positionStart, int itemCount) {
        updateItem(positionStart, itemCount, false);
    }

    /**
     * Remove item
     *
     * @param position all in 0 <= position < getItemCount or mList.size()
     * @param isScroll
     */
    @Override
    public void removeItem(int position, boolean isScroll) {
        if (position >= 0 && position < getItemCount()) {
            mList.remove(position);

            mRecyclerView.post(() -> notifyItemRemoved(position));

            if (isScroll) {
                int positionNew = position - 1;
                mRecyclerView.scrollToPosition(positionNew >= 0 ? positionNew : 0);
            }
        }
    }

    @Override
    public void removeItem(int position) {
        removeItem(position, false);
    }

    /**
     * Remove list item
     *
     * @param positionStart all in 0 <= position < getItemCount or mList.size()
     * @param itemCount     size of list remove. eg: list.size()
     * @param isScroll
     */
    @Override
    public void removeItem(int positionStart, int itemCount, boolean isScroll) {
        if (positionStart >= 0 && itemCount > 0 && (positionStart + itemCount) < getItemCount()) {
            for (int i = 0; i < itemCount; i++) {
                mList.remove(positionStart);
            }

            mRecyclerView.post(() -> notifyItemRangeRemoved(positionStart, itemCount));

            if (isScroll) {
                int positionNew = positionStart - 1;
                mRecyclerView.scrollToPosition(positionNew >= 0 ? positionNew : 0);
            }
        }
    }

    @Override
    public void removeItem(int positionStart, int itemCount) {
        removeItem(positionStart, itemCount, false);
    }

    /**
     * Moved item
     *
     * @param fromPosition
     * @param toPosition
     * @param isScroll
     */
    @Override
    public void movedItem(int fromPosition, int toPosition, boolean isScroll) {
        int sizeList = getItemCount();
        if (fromPosition >= 0 && fromPosition < sizeList
                && toPosition >= 0 && toPosition < sizeList
                && fromPosition != toPosition) {
            Object obj = mList.get(fromPosition);
            mList.remove(fromPosition);
            mList.add(toPosition, obj);

            mRecyclerView.post(() -> notifyItemMoved(fromPosition, toPosition));

            if (isScroll) {
                mRecyclerView.scrollToPosition(toPosition);
            }
        }
    }

    @Override
    public void movedItem(int fromPosition, int toPosition) {
        movedItem(fromPosition, toPosition, false);
    }

    /**
     * Reload all adapter
     *
     * @param isScroll true: scroll to position 0, false: not scroll
     */
    @Override
    public void reloadAll(boolean isScroll) {
        mRecyclerView.post(() -> notifyDataSetChanged());

        if (isScroll) {
            mRecyclerView.scrollToPosition(0);
        }
    }

    @Override
    public void reloadAll() {
        reloadAll(false);
    }
}
