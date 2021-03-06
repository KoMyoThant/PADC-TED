package com.ps.ted.data.db;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ps.ted.data.vo.TalkVO;


import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by pyaesone on 1/31/18.
 */

public class TalkTypeConvector {

    @TypeConverter
    public String fromTalkList(List<TalkVO> talkList) {
        if (talkList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<TalkVO>>() {
        }.getType();
        String json = gson.toJson(talkList, type);
        return json;
    }

    @TypeConverter
    public List<TalkVO> toTalkList(String talkStr) {
        if (talkStr == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<TalkVO>>() {
        }.getType();
        List<TalkVO> tagList = gson.fromJson(talkStr, type);
        return tagList;
    }
}
