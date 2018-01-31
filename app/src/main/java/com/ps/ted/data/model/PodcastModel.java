package com.ps.ted.data.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.ps.ted.TEDApp;
import com.ps.ted.data.vo.PodcastVO;
import com.ps.ted.network.responses.GetPodcastResponse;
import com.ps.ted.utils.AppConstants;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by pyaesone on 1/31/18.
 */

public class PodcastModel extends BaseModel {

    //TODO to delete
    public MutableLiveData<List<PodcastVO>> podcastList;

    public PodcastModel() {
        super();
        podcastList = new MutableLiveData<>();
    }

    public LiveData<List<PodcastVO>> getPodcastList() {
        return mAppDatabase.podcastDao().getAllPodcasts();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public LiveData<List<PodcastVO>> startLoadingPodcastList() {
        return loadPodcastList(AppConstants.ACCESS_TOKEN, configUtils.loadPodcastPageIndex());
    }

    public LiveData<List<PodcastVO>> loadPodcastList(String accessToken, int pageNo) {
        Observable<GetPodcastResponse> podcastResponseObservable = retrofitDataAgent.getTEDApi().loadTEDPodcasts(accessToken, pageNo);
        podcastResponseObservable
                .subscribeOn(Schedulers.io()) //run value creation code on a specific thread (non-UI thread)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetPodcastResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetPodcastResponse getPodcastResponse) {
                        podcastList.setValue(getPodcastResponse.getPodcastList());
                        configUtils.savePodcastPageIndex(getPodcastResponse.getPageNo() + 1);

                        Log.d(TEDApp.LOG_TAG, "podcastList size onNext : " + podcastList.getValue().size());

                        long[] insertedIds = mAppDatabase.podcastDao().insertPodcasts(getPodcastResponse.getPodcastList().toArray(new PodcastVO[0]));
                        Log.d(TEDApp.LOG_TAG, "insertedIds podcasts : " + insertedIds.length);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return podcastList;

    }

    public LiveData<List<PodcastVO>> loadMorePodcastlists(){
        return loadPodcastList(AppConstants.ACCESS_TOKEN, configUtils.loadPodcastPageIndex());
    }
}
