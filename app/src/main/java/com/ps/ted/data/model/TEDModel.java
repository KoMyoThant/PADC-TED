package com.ps.ted.data.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.ps.ted.TEDApp;
import com.ps.ted.data.vo.SpeakerVO;
import com.ps.ted.data.vo.TagVO;
import com.ps.ted.data.vo.TalkVO;
import com.ps.ted.network.responses.GetTalkResponse;
import com.ps.ted.utils.AppConstants;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by pyaesone on 1/26/18.
 */

public class TEDModel extends BaseModel {

    //TODO to delete
    public MutableLiveData<List<TalkVO>> talkList;

    public TEDModel() {
        super();
        talkList = new MutableLiveData<>();
    }

    public LiveData<List<TalkVO>> getTalks() {
        return mAppDatabase.talksDao().getAllTalks();
    }

    public LiveData<List<TagVO>> getTags() {
        return mAppDatabase.tagDao().getAllTags();
    }

    public LiveData<List<SpeakerVO>> getSpeakers() {
        return mAppDatabase.speakerDao().getAllSpeakers();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public LiveData<List<TalkVO>> startLoadingTalks() {
        return loadTalks(AppConstants.ACCESS_TOKEN, configUtils.loadTalkPageIndex());
    }

    public LiveData<List<TalkVO>> loadTalks(String accessToken, int pageNo) {
        Observable<GetTalkResponse> talksResponseObservable = retrofitDataAgent.getTEDApi().loadTEDTalks(accessToken, pageNo);
        talksResponseObservable
                .subscribeOn(Schedulers.io()) //run value creation code on a specific thread (non-UI thread)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetTalkResponse>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull GetTalkResponse getTalksResponse) {
                        talkList.setValue(getTalksResponse.getTalkList());
                        configUtils.saveTalkPageIndex(getTalksResponse.getPageNo() + 1);

                        Log.d(TEDApp.LOG_TAG, "talkList size onNext : " + talkList.getValue().size());

                        long[] insertedIds = mAppDatabase.talksDao().insertTalks(getTalksResponse.getTalkList().toArray(new TalkVO[0]));
                        Log.d(TEDApp.LOG_TAG, "insertedIds talks : " + insertedIds.length);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return talkList;

    }

    public LiveData<List<TalkVO>> loadMoreTalks(){
        return loadTalks(AppConstants.ACCESS_TOKEN, configUtils.loadTalkPageIndex());
    }

}
