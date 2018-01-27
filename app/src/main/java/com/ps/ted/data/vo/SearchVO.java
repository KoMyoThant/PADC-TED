package com.ps.ted.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pyaesone on 1/27/18.
 */

@Entity(tableName = "search")
public class SearchVO {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("search_result_id")
    private long searchResultId;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("imageUrl")
    private String image;

    @SerializedName("result_type")
    private String resultType;

    @SerializedName("result_id")
    private long resultId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSearchResultId() {
        return searchResultId;
    }

    public void setSearchResultId(long searchResultId) {
        this.searchResultId = searchResultId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public long getResultId() {
        return resultId;
    }

    public void setResultId(long resultId) {
        this.resultId = resultId;
    }
}
