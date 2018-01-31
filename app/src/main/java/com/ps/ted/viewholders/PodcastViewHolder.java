package com.ps.ted.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ps.ted.R;
import com.ps.ted.data.vo.PodcastVO;
import com.ps.ted.delegates.PodcastItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pyaesone on 1/25/18.
 */

public class PodcastViewHolder extends BaseViewHolder<PodcastVO> {

    @BindView(R.id.iv_podcast_placeholder_image)
    ImageView ivPodcastHeroImage;

    @BindView(R.id.tv_podcast_title)
    TextView tvPodcastTitle;

    @BindView(R.id.tv_podcast_brief)
    TextView tvPodcastBrief;

    private PodcastItemDelegate mPodcastItemDelegate;

    public PodcastViewHolder(View itemView, PodcastItemDelegate podcastItemDelegate) {
        super(itemView);
        mPodcastItemDelegate = podcastItemDelegate;
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(PodcastVO data) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.img_placeholder)
                .centerCrop();

        tvPodcastTitle.setText(data.getTitle());
        tvPodcastBrief.setText(data.getDescription());

        Glide.with(itemView.getContext())
                .load(data.getImage())
                .apply(requestOptions)
                .into(ivPodcastHeroImage);
    }

    @Override
    public void onClick(View view) {
        mPodcastItemDelegate.onTapPodcast();
    }
}
