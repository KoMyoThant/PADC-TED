package com.ps.ted.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pyaesone on 1/26/18.
 */
@Entity(tableName = "speaker")
public class SpeakerVO {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("speaker_id")
    private long speakerId;

    @SerializedName("name")
    private String name;

    public long getId() {
        return id;
    }

    public long getSpeakerId() {
        return speakerId;
    }

    public String getName() {
        return name;
    }
}
