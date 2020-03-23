package com.centralweather.domain.cloud;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.centralweather.utility.RetrofitGsonTypeAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Amber_Chen on 2020-03-18.
 */
public class WeatherApiClient {
    public final static String PRODUCT_SERVER = "https://opendata.cwb.gov.tw/";
    public final static String AUTHORIZATION_KEY = "CWB-F7DBD556-C08C-4D7A-A412-235841B4C613";
    private static final WeatherApiClient ourInstance = new WeatherApiClient();
    private WeatherApi weatherApi;

    private static WeatherApiClient getInstance() {
        return ourInstance;
    }

    private WeatherApiClient() {
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(RetrofitGsonTypeAdapterFactory.create()).create();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(loggingInterceptor);
        builder.connectTimeout(4, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(PRODUCT_SERVER )
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
        weatherApi = retrofit.create(WeatherApi.class);
    }


    public static WeatherApi getWeatherApi() {
        return getInstance().weatherApi;
    }
}
