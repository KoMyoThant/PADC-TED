package com.ps.ted.data.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.ps.ted.data.db.AppDatabase;
import com.ps.ted.data.vo.SpeakerVO;
import com.ps.ted.data.vo.TagVO;
import com.ps.ted.data.vo.TalkVO;

import java.util.List;

/**
 * Created by pyaesone on 1/26/18.
 */

public class TEDModel extends ViewModel {

    private AppDatabase mAppDatabase;

    public TEDModel() {
//        mDataAgent.loadAttractions();
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
}
