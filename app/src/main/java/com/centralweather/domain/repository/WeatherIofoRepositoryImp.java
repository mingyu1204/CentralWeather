package com.centralweather.domain.repository;

import com.google.gson.Gson;

import com.centralweather.domain.converter.WeatherTemperatureInfoConverter;
import com.centralweather.exception.ResponseException;
import com.centralweather.domain.cloud.WeatherApiClient;
import com.centralweather.domain.entity.WeatherTemperatureInfo;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Single;
import timber.log.Timber;

/**
 * Created by Amber_Chen on 2020-03-20.
 */
public class WeatherIofoRepositoryImp implements WeatherIofoRepository {

    public WeatherIofoRepositoryImp() {

    }

    @Override
    public Single<List<WeatherTemperatureInfo>> getWeatherTemperatureInfo(String location,String element) {
        List<String> locations = Arrays.asList(location);
        List<String> elements = Arrays.asList(element);
        return WeatherApiClient.getWeatherApi()
                .getWeatherData(WeatherApiClient.AUTHORIZATION_KEY, locations, elements)
                .flatMap(weatherResponse -> {
                    Timber.d(new Gson().toJson(weatherResponse).toString());
                    if (weatherResponse.success().equalsIgnoreCase("true") && null!= weatherResponse.records()) {
                        return Single.just(WeatherTemperatureInfoConverter.toWeatherTemperatureInfos(weatherResponse.records()));
                    } else {
                        return Single.error(new ResponseException());
                    }
                });

    }
}
