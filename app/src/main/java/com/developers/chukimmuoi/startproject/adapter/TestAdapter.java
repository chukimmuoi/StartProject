package com.developers.chukimmuoi.startproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.developers.chukimmuoi.shared.ui.recycler.BaseRecyclerAdapter;
import com.developers.chukimmuoi.shared.ui.recycler.BaseRecyclerView;
import com.developers.chukimmuoi.startproject.R;
import com.developers.chukimmuoi.startproject.model.Contact;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : StartProject
 * Created by chukimmuoi on 4/2/17.
 */

public class TestAdapter extends BaseRecyclerAdapter<TestAdapter.ViewHolder> {

    private static final String TAG = TestAdapter.class.getSimpleName();

    public TestAdapter(Context mContext, BaseRecyclerView recyclerView, ArrayList<? super Object> mList) {
        super(mContext, recyclerView, mList);
    }

    @Override
    protected View setLayout(LayoutInflater inflater, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_contact, parent, false);
        return view;
    }

    @Override
    protected ViewHolder createViewHolder(View view) {
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void displayItem(ViewHolder viewHolder, int position) {
        Contact item = (Contact) mList.get(position);

        TextView textView = viewHolder.contactName;
        textView.setText(item.getName() + ", " + position);

        Button button = viewHolder.messageButton;
        if (item.isOnline()) {
            button.setText("Message");
            button.setEnabled(true);
        } else {
            button.setText("Offline");
            button.setEnabled(false);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.contact_name)
        TextView contactName;

        @BindView(R.id.message_button)
        Button messageButton;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
