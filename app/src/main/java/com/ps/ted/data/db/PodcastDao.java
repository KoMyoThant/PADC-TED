package com.ps.ted.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.ps.ted.data.vo.PodcastVO;

import java.util.List;

/**
 * Created by pyaesone on 1/27/18.
 */

@Dao
public interface PodcastDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertPodcast(PodcastVO podcast);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertPodcasts(PodcastVO... podcasts);

    @Query("SELECT * FROM podcast")
    LiveData<List<PodcastVO>> getAllPodcasts();

    @Query("DELETE FROM podcast")
    void deleteAll();
}
