package com.centralweather.presentation.main;

import com.centralweather.R;
import com.centralweather.domain.entity.WeatherTemperatureInfo;
import com.centralweather.domain.repository.WeatherIofoRepositoryImp;
import com.centralweather.presentation.detail.WeatherDetailActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WeatherMainActivity extends AppCompatActivity {
    @BindView(R.id.rlWeatherList)
    RecyclerView rlWeatherList;

    public static final String INTENT_WEATHER_INFO = "INTENT_WEATHER_INFO";
    private WeatherMainViewModel weatherMainViewModel;
    private WeatherItemAdapter adapter;
    private Disposable dataDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_main);
        ButterKnife.bind(this);
        initView();
        initData();

    }

    private void initView() {
        adapter = new WeatherItemAdapter();
        adapter.setOnItemClickListener(weatherTemperatureInfo -> goDetailPage(weatherTemperatureInfo));
        rlWeatherList.setAdapter(adapter);
        rlWeatherList.setLayoutManager(new LinearLayoutManager(this));
        rlWeatherList.setOverScrollMode(View.OVER_SCROLL_NEVER);
        rlWeatherList.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        weatherMainViewModel = new WeatherMainViewModel(getApplication(),new WeatherIofoRepositoryImp());

        if( weatherMainViewModel.isLaunched()){
            Toast.makeText(this,getString(R.string.dialogContent), Toast.LENGTH_LONG).show();
        }

        dataDisposable = weatherMainViewModel.getWeatherTemperatureInfos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(weatherTemperatureInfos ->
                                adapter.setWeatherTemperatureInfos(weatherTemperatureInfos)
                        , throwable -> throwable.printStackTrace());
    }

    private void goDetailPage(WeatherTemperatureInfo weatherTemperatureInfo) {
        Intent intent = new Intent(this, WeatherDetailActivity.class);
        intent.putExtra(INTENT_WEATHER_INFO, weatherTemperatureInfo);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        weatherMainViewModel.setLaunchStatus(true);
        if (null != dataDisposable && !dataDisposable.isDisposed()) {
            dataDisposable.dispose();
        }

    }
}