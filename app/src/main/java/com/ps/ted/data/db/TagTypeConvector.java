package com.ps.ted.data.db;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ps.ted.data.vo.TagVO;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by pyaesone on 1/27/18.
 */

public class TagTypeConvector {

    @TypeConverter
    public String fromTagList(List<TagVO> tagList) {
        if (tagList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<TagVO>>() {
        }.getType();
        String json = gson.toJson(tagList, type);
        return json;
    }

    @TypeConverter
    public List<TagVO> toTagList(String tagStr) {
        if (tagStr == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<TagVO>>() {
        }.getType();
        List<TagVO> tagList = gson.fromJson(tagStr, type);
        return tagList;
    }
}
