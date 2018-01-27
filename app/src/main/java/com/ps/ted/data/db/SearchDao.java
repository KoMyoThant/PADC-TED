package com.ps.ted.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.ps.ted.data.vo.SearchVO;

import java.util.List;

/**
 * Created by pyaesone on 1/27/18.
 */

@Dao
public interface SearchDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertSearch(SearchVO search);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertSearchs(SearchVO... searchs);

    @Query("SELECT * FROM search")
    LiveData<List<SearchVO>> getAllSearchs();

    @Query("DELETE FROM search")
    void deleteAll();
}
