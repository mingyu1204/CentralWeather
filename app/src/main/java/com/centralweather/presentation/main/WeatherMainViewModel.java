package com.centralweather.presentation.main;

import com.centralweather.domain.entity.WeatherTemperatureInfo;
import com.centralweather.domain.repository.WeatherIofoRepository;
import com.centralweather.utility.Define;
import com.centralweather.utility.SharedPrefMgr;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import io.reactivex.Single;

/**
 * Created by Amber_Chen on 2020-03-21.
 */
public class WeatherMainViewModel extends AndroidViewModel {
    private WeatherIofoRepository weatherIofoRepository;

    public WeatherMainViewModel(@NonNull Application application, WeatherIofoRepository weatherIofoRepository) {
        super(application);
        this.weatherIofoRepository = weatherIofoRepository;

    }

    public Single<List<WeatherTemperatureInfo>> getWeatherTemperatureInfos() {
        return weatherIofoRepository.getWeatherTemperatureInfo(Define.CityType.TAIPEI.city, Define.ElementType.MIN_T.element);
    }

    public void setLaunchStatus(boolean isLaunched) {
        SharedPrefMgr.saveSharedPref(getApplication(), Define.SPFS_LAUNCH_STATUS, isLaunched, Define.SPFS_CATEGORY);
    }

    public boolean isLaunched() {
        return SharedPrefMgr.loadSharedPref(getApplication(), Define.SPFS_LAUNCH_STATUS, false, Define.SPFS_CATEGORY);
    }

}