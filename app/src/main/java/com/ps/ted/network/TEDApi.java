package com.ps.ted.network;

import com.ps.ted.network.responses.GetPlaylistResponse;
import com.ps.ted.network.responses.GetPodcastResponse;
import com.ps.ted.network.responses.GetSearchResponse;
import com.ps.ted.network.responses.GetTalkResponse;
import com.ps.ted.util.AppConstants;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by pyaesone on 1/26/18.
 */

public interface TEDApi {

    @FormUrlEncoded
    @POST(AppConstants.API_GET_TALK_LIST)
    Observable<GetTalkResponse> loadTEDTalks(
            @Field(AppConstants.PARAM_ACCESS_TOKEN) String accessToken, @Field(AppConstants.PARAM_PAGE) int pageIndex);

    @FormUrlEncoded
    @POST(AppConstants.API_GET_PLAYLIST_LIST)
    Observable<GetPlaylistResponse> loadTEDPlaylists(
            @Field(AppConstants.PARAM_ACCESS_TOKEN) String accessToken, @Field(AppConstants.PARAM_PAGE) int pageIndex);

    @FormUrlEncoded
    @POST(AppConstants.API_GET_PODCAST_LIST)
    Observable<GetPodcastResponse> loadTEDPodcasts(
            @Field(AppConstants.PARAM_ACCESS_TOKEN) String accessToken, @Field(AppConstants.PARAM_PAGE) int pageIndex);

    @FormUrlEncoded
    @POST(AppConstants.API_GET_SEARCH_LIST)
    Observable<GetSearchResponse> loadTEDSearchs(
            @Field(AppConstants.PARAM_ACCESS_TOKEN) String accessToken, @Field(AppConstants.PARAM_PAGE) int pageIndex);
}
