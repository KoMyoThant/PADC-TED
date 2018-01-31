package com.ps.ted.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ps.ted.R;
import com.ps.ted.data.vo.PlaylistVO;
import com.ps.ted.delegates.PlaylistItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pyaesone on 1/24/18.
 */

public class PlaylistViewHolder extends BaseViewHolder<PlaylistVO> {

    @BindView(R.id.iv_play_info_placeholder_image)
    ImageView ivPlaylistHeroImg;

    @BindView(R.id.tv_play_title)
    TextView tvPlayTitle;

    @BindView(R.id.tv_player_count)
    TextView tvPlayerCount;

    @BindView(R.id.tv_play_duration)
    TextView tvPlayDuration;

    private PlaylistItemDelegate mPlaylistItemDelegate;

    public PlaylistViewHolder(View itemView, PlaylistItemDelegate playlistItemDelegate) {
        super(itemView);
        mPlaylistItemDelegate = playlistItemDelegate;
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(PlaylistVO data) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.img_placeholder)
                .centerCrop();

        tvPlayTitle.setText(data.getTitle());
        tvPlayerCount.setText(String.valueOf(data.getTotalTalks()));
        tvPlayDuration.setText("15:00");

        Glide.with(itemView.getRootView().getContext())
                .load(data.getImage())
                .apply(requestOptions)
                .into(ivPlaylistHeroImg);
    }

    @Override
    public void onClick(View view) {
        mPlaylistItemDelegate.onTapPlaylist();
    }
}
