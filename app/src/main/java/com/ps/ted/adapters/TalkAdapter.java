package com.ps.ted.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ps.ted.R;
import com.ps.ted.delegates.TalkItemDelegate;
import com.ps.ted.viewholders.TalkViewHolder;

/**
 * Created by pyaesone on 1/24/18.
 */

public class TalkAdapter extends RecyclerView.Adapter {

    private LayoutInflater mInflater;
    private Context mContext;
    private TalkItemDelegate mTalkItemDelegate;

    public TalkAdapter(Context context,TalkItemDelegate talkItemDelegate) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mTalkItemDelegate = talkItemDelegate;
    }

    @Override
    public TalkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.view_item_talk, parent, false);

        return new TalkViewHolder(view,mTalkItemDelegate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
