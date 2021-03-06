/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ps.ted.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.ps.ted.data.vo.PlaylistVO;
import com.ps.ted.data.vo.PodcastVO;
import com.ps.ted.data.vo.SearchVO;
import com.ps.ted.data.vo.SegmentVO;
import com.ps.ted.data.vo.SpeakerVO;
import com.ps.ted.data.vo.TagVO;
import com.ps.ted.data.vo.TalkVO;

@Database(entities = {TalkVO.class, TagVO.class, SpeakerVO.class, PlaylistVO.class, PodcastVO.class, SearchVO.class, SegmentVO.class}, version = 8)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "PADC-TED.DB";

    private static AppDatabase INSTANCE;

    public abstract TalkDao talksDao();

    public abstract TagDao tagDao();

    public abstract SpeakerDao speakerDao();

    public abstract PlaylistDao playlistDao();

    public abstract PodcastDao podcastDao();

    public abstract SearchDao searchDao();

    public abstract SegmentDao segmentDao();

    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                            .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}