package com.ps.ted.network;

import com.ps.ted.network.responses.GetTalkResponse;
import com.ps.ted.util.AppConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by pyaesone on 1/26/18.
 */

public interface TEDApi {

    @FormUrlEncoded
    @POST(AppConstants.API_GET_TALK_LIST)
    Call<GetTalkResponse> loadBurpplePromotions(
            @Field(AppConstants.PARAM_ACCESS_TOKEN) String accessToken, @Field(AppConstants.PARAM_PAGE) int pageIndex);
}
