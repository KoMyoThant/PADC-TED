package com.ps.ted.data.db;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ps.ted.data.vo.SegmentVO;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by pyaesone on 1/31/18.
 */

public class SegmentTypeConvector {
    @TypeConverter
    public String fromSegmentList(List<SegmentVO> segmentList) {
        if (segmentList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<SegmentVO>>() {
        }.getType();
        String json = gson.toJson(segmentList, type);
        return json;
    }

    @TypeConverter
    public List<SegmentVO> toSegmentList(String segmentStr) {
        if (segmentStr == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<SegmentVO>>() {
        }.getType();
        List<SegmentVO> segmentList = gson.fromJson(segmentStr, type);
        return segmentList;
    }
}
