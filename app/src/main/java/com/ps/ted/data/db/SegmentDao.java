package com.ps.ted.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.ps.ted.data.vo.SegmentVO;

import java.util.List;

/**
 * Created by pyaesone on 1/27/18.
 */

@Dao
public interface SegmentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertSegment(SegmentVO segment);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertSegments(SegmentVO... segments);

    @Query("SELECT * FROM segment")
    LiveData<List<SegmentVO>> getAllSegments();

    @Query("DELETE FROM segment")
    void deleteAll();
}
