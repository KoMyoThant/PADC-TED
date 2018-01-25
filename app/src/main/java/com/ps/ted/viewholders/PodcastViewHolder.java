package com.ps.ted.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ps.ted.delegates.PodcastItemDelegate;

/**
 * Created by pyaesone on 1/25/18.
 */

public class PodcastViewHolder extends RecyclerView.ViewHolder {

    private PodcastItemDelegate mPodcastItemDelegate;

    public PodcastViewHolder(View itemView, PodcastItemDelegate podcastItemDelegate) {
        super(itemView);
        mPodcastItemDelegate = podcastItemDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPodcastItemDelegate.onTapPodcast();
            }
        });
    }
}
