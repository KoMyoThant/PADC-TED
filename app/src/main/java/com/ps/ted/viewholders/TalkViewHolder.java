package com.ps.ted.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ps.ted.delegates.TalkItemDelegate;

/**
 * Created by pyaesone on 1/24/18.
 */

public class TalkViewHolder extends RecyclerView.ViewHolder {

    private TalkItemDelegate mTalkItemDelegate;

    public TalkViewHolder(View itemView,TalkItemDelegate talkItemDelegate) {
        super(itemView);
        mTalkItemDelegate = talkItemDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTalkItemDelegate.onTapTalk();
            }
        });
    }
}
