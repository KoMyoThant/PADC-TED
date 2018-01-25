package com.ps.ted.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.ps.ted.data.vo.SpeakerVO;

import java.util.List;

/**
 * Created by pyaesone on 1/26/18.
 */

@Dao
public interface SpeakerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertSpeaker(SpeakerVO speaker);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertSpeakers(SpeakerVO... speakers);

    @Query("SELECT * FROM speaker")
    LiveData<List<SpeakerVO>> getAllSpeakers();

    @Query("DELETE FROM speaker")
    void deleteAll();
}
