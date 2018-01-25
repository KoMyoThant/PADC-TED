package com.ps.ted.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.ps.ted.data.vo.TagVO;

import java.util.List;

/**
 * Created by pyaesone on 1/26/18.
 */

@Dao
public interface TagDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertTag(TagVO tag);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertTags(TagVO... tags);

    @Query("SELECT * FROM tag")
    LiveData<List<TagVO>> getAllTags();

    @Query("DELETE FROM tag")
    void deleteAll();
}
