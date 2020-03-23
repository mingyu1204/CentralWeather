package com.centralweather.domain.converter;
import com.centralweather.domain.databean.Records;
import com.centralweather.domain.databean.TimeItem;
import com.centralweather.domain.entity.WeatherTemperatureInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amber_Chen on 2020-03-21.
 */
public class WeatherTemperatureInfoConverter {

    public static List<WeatherTemperatureInfo> toWeatherTemperatureInfos(Records records) {
        List<WeatherTemperatureInfo> weatherTemperatureInfos = new ArrayList<>();
        List<TimeItem> timeItems = records.location().get(0).weatherElement().get(0).time();

        for (TimeItem timeItem : timeItems) {
            weatherTemperatureInfos.add(
                    WeatherTemperatureInfo.newBuilder()
                            .tartTime(timeItem.startTime())
                            .endTime(timeItem.endTime())
                            .parameterName(timeItem.parameter().parameterName())
                            .parameterUnit(timeItem.parameter().parameterUnit())
                            .build()
            );
        }

        return weatherTemperatureInfos;
    }

}
