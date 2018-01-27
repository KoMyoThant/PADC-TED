package com.ps.ted.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.ps.ted.data.vo.PlaylistVO;

import java.util.List;

/**
 * Created by pyaesone on 1/27/18.
 */

@Dao
public interface PlaylistDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertPlaylist(PlaylistVO playlist);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertPlaylists(PlaylistVO... playlists);

    @Query("SELECT * FROM playlist")
    LiveData<List<PlaylistVO>> getAllPlaylists();

    @Query("DELETE FROM playlist")
    void deleteAll();
}
