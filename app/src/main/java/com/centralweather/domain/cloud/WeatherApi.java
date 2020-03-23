package com.centralweather.domain.cloud;

import com.centralweather.domain.databean.WeatherResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Amber_Chen on 2020-03-18.
 */


public interface WeatherApi {
    @GET("api/v1/rest/datastore/F-C0032-001")
    Single<WeatherResponse> getWeatherData(@Query("Authorization") String authorizationKey
            , @Query("locationName") List<String> locationName, @Query("elementName") List<String> elementName);




}
