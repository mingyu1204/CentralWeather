package com.centralweather.presentation.detail;

import com.centralweather.domain.entity.WeatherTemperatureInfo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Amber_Chen on 2020-03-20.
 */
public class WeatherDetailViewModel extends ViewModel {
    public final MutableLiveData<String> startTime = new MutableLiveData<>();
    public final MutableLiveData<String> endTime = new MutableLiveData<>();
    public final MutableLiveData<String> parameterName = new MutableLiveData<>();
    public final MutableLiveData<String> parameterUnit = new MutableLiveData<>();

    public WeatherDetailViewModel() {

    }

    public void updateUi(WeatherTemperatureInfo weatherTemperatureInfo){
        startTime.setValue(weatherTemperatureInfo.getTartTime());
        endTime.setValue(weatherTemperatureInfo.getEndTime());
        parameterName.setValue(weatherTemperatureInfo.getParameterName());
        parameterUnit.setValue(weatherTemperatureInfo.getParameterUnit());
    }

}