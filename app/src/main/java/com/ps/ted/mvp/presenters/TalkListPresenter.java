package com.ps.ted.mvp.presenters;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;

import com.ps.ted.data.model.TEDModel;
import com.ps.ted.data.vo.TalkVO;
import com.ps.ted.delegates.TalkItemDelegate;
import com.ps.ted.mvp.views.TalkListView;

import java.util.List;

/**
 * Created by pyaesone on 1/31/18.
 */

public class TalkListPresenter extends BasePresenter<TalkListView> implements TalkItemDelegate {

    private TEDModel mTedModel;
    private LifecycleOwner mLifecycleOwner;

    public TalkListPresenter(LifecycleOwner lifecycleOwner,TEDModel tedModel) {
        mLifecycleOwner = lifecycleOwner;
        mTedModel = tedModel;
    }

    @Override
    public void onTapTalk() {
    }

    @Override
    public void onCreate(TalkListView View) {
        super.onCreate(View);
    }

    @Override
    public void onStart() {
        mTedModel.getTalks().observe(mLifecycleOwner, new Observer<List<TalkVO>>() {
            @Override
            public void onChanged(@Nullable final List<TalkVO> talkList) {
                if (!talkList.isEmpty()) {
                    mView.displayTalkList(talkList);
                } else {
                    mView.refreshTalkList();
                    mTedModel.startLoadingTalks().observe(mLifecycleOwner, new Observer<List<TalkVO>>() {
                        @Override
                        public void onChanged(@Nullable List<TalkVO> talkVOS) {
                            mView.displayTalkList(talkVOS);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onStop() {

    }
}
