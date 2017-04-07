package com.developers.chukimmuoi.shared.ui.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
     */
    @Override
    public void insertItem(int position, Object object) {
        if (position >= 0 && object != null) {
            mList.add(position, object);

            notifyItemInserted(position);

            mRecyclerView.scrollToPosition(position);
        }
    }

    /**
     * Add list item
     *
     * @param positionStart getItemCount or mList.size()
     * @param insertList    list object
     */
    @Override
    public void insertItem(int positionStart, List<? super Object> insertList) {
        if (positionStart >= 0 && insertList != null) {
            int itemCount = insertList.size();
            if (itemCount > 0) {
                mList.addAll(positionStart, insertList);

                notifyItemRangeInserted(positionStart, itemCount);

                mRecyclerView.scrollToPosition(positionStart);
            }
        }
    }

    /**
     * Update item
     *
     * @param position all in 0 <= position < getItemCount or mList.size()
     */
    @Override
    public void updateItem(int position) {
        if (position >= 0 && position < getItemCount()) {
            notifyItemChanged(position);

            mRecyclerView.scrollToPosition(position);
        }
    }

    /**
     * Update list item
     *
     * @param positionStart all in 0 <= position < getItemCount or mList.size()
     * @param itemCount     size of list update. eg: list.size()
     */
    @Override
    public void updateItem(int positionStart, int itemCount) {
        if (positionStart >= 0 && itemCount > 0 && (positionStart + itemCount) < getItemCount()) {
            notifyItemRangeChanged(positionStart, itemCount);

            mRecyclerView.scrollToPosition(positionStart);
        }
    }

    /**
     * Remove item
     *
     * @param position all in 0 <= position < getItemCount or mList.size()
     */
    @Override
    public void removeItem(int position) {
        if (position >= 0 && position < getItemCount()) {
            mList.remove(position);

            notifyItemRemoved(position);

            int positionNew = position - 1;
            mRecyclerView.scrollToPosition(positionNew >= 0 ? positionNew : 0);
        }
    }

    /**
     * Remove list item
     *
     * @param positionStart all in 0 <= position < getItemCount or mList.size()
     * @param itemCount     size of list remove. eg: list.size()
     */
    @Override
    public void removeItem(int positionStart, int itemCount) {
        if (positionStart >= 0 && itemCount > 0 && (positionStart + itemCount) < getItemCount()) {
            for (int i = 0; i < itemCount; i++) {
                mList.remove(positionStart);
            }

            notifyItemRangeRemoved(positionStart, itemCount);

            int positionNew = positionStart - 1;
            mRecyclerView.scrollToPosition(positionNew >= 0 ? positionNew : 0);
        }
    }

    /**
     * Moved item
     *
     * @param fromPosition
     * @param toPosition
     */
    @Override
    public void movedItem(int fromPosition, int toPosition) {
        int sizeList = getItemCount();
        if (fromPosition >= 0 && fromPosition < sizeList
                && toPosition >= 0 && toPosition < sizeList
                && fromPosition != toPosition) {
            Object obj = mList.get(fromPosition);
            mList.remove(fromPosition);
            mList.add(toPosition, obj);

            notifyItemMoved(fromPosition, toPosition);

            mRecyclerView.scrollToPosition(toPosition);
        }
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
}
