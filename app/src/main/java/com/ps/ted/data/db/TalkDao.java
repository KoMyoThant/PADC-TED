package com.ps.ted.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.ps.ted.data.vo.TalkVO;

import java.util.List;

/**
 * Created by pyaesone on 1/26/18.
 */

@Dao
public interface TalkDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertTalk(TalkVO talk);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertTalks(TalkVO... talks);

    @Query("SELECT * FROM attractions")
    LiveData<List<TalkVO>> getAllTalks();

    @Query("DELETE FROM talk")
    void deleteAll();
}
