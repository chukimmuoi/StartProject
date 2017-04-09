package com.developers.chukimmuoi.shared.ui.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developers.chukimmuoi.shared.ui.recycler.view.IBaseRecyclerAdapter;

import java.util.List;


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

        View view = setLayout(inflater, parent);

        VH viewHolder = createViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        displayItem(holder, position);
    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
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

            notifyItemInserted(position);

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

                notifyItemRangeInserted(positionStart, itemCount);

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
            notifyItemChanged(position);

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
            notifyItemRangeChanged(positionStart, itemCount);

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

            notifyItemRemoved(position);

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

            notifyItemRangeRemoved(positionStart, itemCount);

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

            notifyItemMoved(fromPosition, toPosition);

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
        notifyDataSetChanged();

        if (isScroll) {
            mRecyclerView.scrollToPosition(0);
        }
    }

    @Override
    public void reloadAll() {
        reloadAll(false);
    }
}
