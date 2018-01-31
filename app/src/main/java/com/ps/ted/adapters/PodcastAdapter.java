package com.ps.ted.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ps.ted.R;
import com.ps.ted.data.vo.PodcastVO;
import com.ps.ted.delegates.PodcastItemDelegate;
import com.ps.ted.viewholders.PodcastViewHolder;

/**
 * Created by pyaesone on 1/25/18.
 */

public class PodcastAdapter extends BaseRecyclerAdapter<PodcastViewHolder,PodcastVO> {

    private PodcastItemDelegate mPodcastItemDelegate;

    public PodcastAdapter(Context context, PodcastItemDelegate podcastItemDelegate) {
        super(context);
        mPodcastItemDelegate = podcastItemDelegate;
    }

    @Override
    public PodcastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.view_item_podcast, parent, false);

        return new PodcastViewHolder(view, mPodcastItemDelegate);
    }

//    @Override
//    public void onBindViewHolder(PodcastViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 7;
//    }
}
