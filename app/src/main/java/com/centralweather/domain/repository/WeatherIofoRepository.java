package com.centralweather.domain.repository;

import com.centralweather.domain.entity.WeatherTemperatureInfo;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Amber_Chen on 2020-03-20.
 */
public interface WeatherIofoRepository {

    Single<List<WeatherTemperatureInfo>> getWeatherTemperatureInfo(String locations, String elements);
}
