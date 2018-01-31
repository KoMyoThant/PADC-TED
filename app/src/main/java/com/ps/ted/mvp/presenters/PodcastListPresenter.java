package com.ps.ted.mvp.presenters;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.ps.ted.data.model.PodcastModel;
import com.ps.ted.data.vo.PodcastVO;
import com.ps.ted.delegates.PodcastItemDelegate;
import com.ps.ted.mvp.views.PodcastView;

import java.util.List;

/**
 * Created by pyaesone on 1/31/18.
 */

public class PodcastListPresenter extends BasePresenter<PodcastView> implements PodcastItemDelegate{

    private PodcastModel mPodcastModel;
    private LifecycleOwner mLifecycleOwner;

    public PodcastListPresenter(LifecycleOwner lifecycleOwner, PodcastModel podcastModel) {
        mLifecycleOwner = lifecycleOwner;
        mPodcastModel = podcastModel;
    }

    @Override
    public void onStart() {
        mPodcastModel.getPodcastList().observe(mLifecycleOwner, new Observer<List<PodcastVO>>() {
            @Override
            public void onChanged(@Nullable List<PodcastVO> podcastVOS) {
                if (!podcastVOS.isEmpty()){
                    mView.displayPodcastList(podcastVOS);
                }else {
                    mView.refreshPodcastList();
                    mPodcastModel.startLoadingPodcastList().observe(mLifecycleOwner, new Observer<List<PodcastVO>>() {
                        @Override
                        public void onChanged(@Nullable List<PodcastVO> podcastVOS) {
                            mView.displayPodcastList(podcastVOS);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onTapPodcast() {

    }

    public void onNewsListEndReach(){
        mPodcastModel.loadMorePodcastlists();
    }
}
