package com.ps.ted.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ps.ted.R;
import com.ps.ted.data.vo.TalkVO;
import com.ps.ted.delegates.TalkItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pyaesone on 1/24/18.
 */

public class TalkViewHolder extends BaseViewHolder<TalkVO> {

    @BindView(R.id.iv_play_info_placeholder_image)
    ImageView ivTalkHeroImage;

    @BindView(R.id.tv_talker_name)
    TextView tvTalkerName;

    @BindView(R.id.tv_talk_title)
    TextView tvTalkTitle;

    @BindView(R.id.tv_talk_duration)
    TextView tvTalkDuration;

    private TalkItemDelegate mTalkItemDelegate;

    public TalkViewHolder(View itemView, TalkItemDelegate talkItemDelegate) {
        super(itemView);
        mTalkItemDelegate = talkItemDelegate;
        ButterKnife.bind(this,itemView);

//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mTalkItemDelegate.onTapTalk();
//            }
//        });
    }


    @Override
    public void setData(TalkVO data) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.img_placeholder)
                .centerCrop();

        tvTalkerName.setText(data.getSpeaker().getName());
        tvTalkTitle.setText(data.getTitle());
        tvTalkDuration.setText(String.valueOf(data.getDurationInSec()));

        Glide.with(itemView.getRootView().getContext())
                .load(data.getImage())
                .apply(requestOptions)
                .into(ivTalkHeroImage);
    }

    @Override
    public void onClick(View view) {
        mTalkItemDelegate.onTapTalk();
    }
}
