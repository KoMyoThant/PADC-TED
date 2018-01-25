package com.ps.ted.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ps.ted.R;

import butterknife.ButterKnife;

/**
 * Created by pyaesone on 1/25/18.
 */

public class SearchActivity extends BaseActivity {

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context,SearchActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this,this);
    }

}
