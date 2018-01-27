package com.ps.ted.data.model;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;

import com.ps.ted.TEDApp;
import com.ps.ted.data.db.AppDatabase;
import com.ps.ted.data.vo.SpeakerVO;
import com.ps.ted.data.vo.TagVO;
import com.ps.ted.data.vo.TalkVO;
import com.ps.ted.network.RetrofitDataAgent;
import com.ps.ted.network.responses.GetTalkResponse;
import com.ps.ted.util.AppConstants;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by pyaesone on 1/26/18.
 */

public class TEDModel extends ViewModel {

    private AppDatabase mAppDatabase;


    private RetrofitDataAgent retrofitDataAgent;

    public TEDModel() {
        retrofitDataAgent = new RetrofitDataAgent();

        loadTalks();
    }

    public void initDatabase(Context context) {
        mAppDatabase = AppDatabase.getInMemoryDatabase(context);
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

        AppDatabase.destroyInstance();
    }

    private Observable<GetTalkResponse> getTalkListResponseObservable() {
        return retrofitDataAgent.getTEDApi().loadTEDTalks(AppConstants.ACCESS_TOKEN, 1);
    }

    public void loadTalks() {
        Observable<GetTalkResponse> talksResponseObservable = getTalkListResponseObservable();
        talksResponseObservable
                .subscribeOn(Schedulers.io()) //run value creation code on a specific thread (non-UI thread)
                .subscribe(new Observer<GetTalkResponse>() {

                    @Override

                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull GetTalkResponse getTalksResponse) {
                        Log.d(TEDApp.LOG_TAG, "RxJava onNext");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
