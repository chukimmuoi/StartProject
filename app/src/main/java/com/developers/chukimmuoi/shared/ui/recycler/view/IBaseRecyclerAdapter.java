package com.developers.chukimmuoi.shared.ui.recycler.view;

import java.util.List;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : StartProject
 * Created by chukimmuoi on 4/3/17.
 */

public interface IBaseRecyclerAdapter {

    void insertItem(int position, Object object, boolean isScroll);

    void insertItem(int position, Object object);

    void insertItem(int positionStart, List<? super Object> insertList, boolean isScroll);

    void insertItem(int positionStart, List<? super Object> insertList);

    void updateItem(int position, boolean isScroll);

    void updateItem(int position);

    void updateItem(int positionStart, int itemCount, boolean isScroll);

    void updateItem(int positionStart, int itemCount);

    void removeItem(int position, boolean isScroll);

    void removeItem(int position);

    void removeItem(int positionStart, int itemCount, boolean isScroll);

    void removeItem(int positionStart, int itemCount);

    void movedItem(int fromPosition, int toPosition, boolean isScroll);

    void movedItem(int fromPosition, int toPosition);

    void reloadAll(boolean isScroll);

    void reloadAll();
}
