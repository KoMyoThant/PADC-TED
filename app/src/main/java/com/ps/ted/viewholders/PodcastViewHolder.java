package com.ps.ted.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ps.ted.data.vo.PodcastVO;
import com.ps.ted.delegates.PodcastItemDelegate;

/**
 * Created by pyaesone on 1/25/18.
 */

public class PodcastViewHolder extends BaseViewHolder<PodcastVO> {

    private PodcastItemDelegate mPodcastItemDelegate;

    public PodcastViewHolder(View itemView, PodcastItemDelegate podcastItemDelegate) {
        super(itemView);
        mPodcastItemDelegate = podcastItemDelegate;
    }

    @Override
    public void setData(PodcastVO data) {

    }

    @Override
    public void onClick(View view) {
        mPodcastItemDelegate.onTapPodcast();
    }
}
