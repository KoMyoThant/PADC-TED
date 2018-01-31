package com.ps.ted.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by pyaesone on 1/31/18.
 */

public class ConfigUtils {

    private static final String KEY_TALK_PAGE_INDEX = "KEY_TALK_PAGE_INDEX";
    private static final String KEY_PLAYLIST_PAGE_INDEX = "KEY_PLAYLIST_PAGE_INDEX";
    private static final String KEY_PODCAST_PAGE_INDEX = "KEY_PODCAST_PAGE_INDEX";

    private static ConfigUtils mObjInstance;

    private SharedPreferences mSharedPreferences;

    private ConfigUtils(Context context) {
        mSharedPreferences = context.getSharedPreferences("ConfigUtils", Context.MODE_PRIVATE);
    }

    public static ConfigUtils getInstance(Context context) {
        if (mObjInstance == null) {
            mObjInstance = new ConfigUtils(context);
        }
        return mObjInstance;
    }


    public void saveTalkPageIndex(int pageIndex) {
        mSharedPreferences.edit().putInt(KEY_TALK_PAGE_INDEX, pageIndex).apply();
    }

    public int loadTalkPageIndex() {
        return mSharedPreferences.getInt(KEY_TALK_PAGE_INDEX, 1);
    }

    public void savePlaylistPageIndex(int pageIndex) {
        mSharedPreferences.edit().putInt(KEY_PLAYLIST_PAGE_INDEX, pageIndex).apply();
    }

    public int loadPlaylistPageIndex() {
        return mSharedPreferences.getInt(KEY_PLAYLIST_PAGE_INDEX, 1);
    }

    public void savePodcastPageIndex(int pageIndex) {
        mSharedPreferences.edit().putInt(KEY_PODCAST_PAGE_INDEX, pageIndex).apply();
    }

    public int loadPodcastPageIndex() {
        return mSharedPreferences.getInt(KEY_PODCAST_PAGE_INDEX, 1);
    }
}
