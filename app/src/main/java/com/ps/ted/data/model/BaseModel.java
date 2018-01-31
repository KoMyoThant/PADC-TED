package com.ps.ted.data.model;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.ps.ted.data.db.AppDatabase;
import com.ps.ted.network.RetrofitDataAgent;
import com.ps.ted.utils.ConfigUtils;

/**
 * Created by pyaesone on 1/31/18.
 */

public class BaseModel extends ViewModel{

    protected AppDatabase mAppDatabase;

    protected RetrofitDataAgent retrofitDataAgent;

    protected ConfigUtils configUtils;

    public BaseModel() {
        retrofitDataAgent = new RetrofitDataAgent();
    }

    public void initDatabase(Context context) {
        mAppDatabase = AppDatabase.getInMemoryDatabase(context);
        configUtils = ConfigUtils.getInstance(context);
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        AppDatabase.destroyInstance();
    }
}
