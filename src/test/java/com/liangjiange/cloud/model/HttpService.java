package com.liangjiange.cloud.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by liangjiange on 2017/3/13.
 */
public interface HttpService {

    @GET("api/test")
    Call<String> getResultById(@Query("id") String id);

}
