package com.centralweather.presentation.detail;

import com.centralweather.R;
import com.centralweather.databinding.ActivityWeatherDetailBinding;
import com.centralweather.domain.entity.WeatherTemperatureInfo;
import com.centralweather.presentation.main.WeatherMainActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.ButterKnife;


/**
 * Created by Amber_Chen on 2020-03-20.
 */
public class WeatherDetailActivity extends AppCompatActivity {


    private WeatherDetailViewModel viewModel;
    private WeatherTemperatureInfo weatherTemperatureInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityWeatherDetailBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_weather_detail);
        ButterKnife.bind(this, binding.getRoot());

        viewModel = ViewModelProviders.of(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new WeatherDetailViewModel();
            }
        }).get(WeatherDetailViewModel.class);

        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
        initData();

    }

    private void initData() {
        weatherTemperatureInfo = (WeatherTemperatureInfo) getIntent().getSerializableExtra(WeatherMainActivity.INTENT_WEATHER_INFO);
        if (null != weatherTemperatureInfo) {
            viewModel.updateUi(weatherTemperatureInfo);

        }
    }
}