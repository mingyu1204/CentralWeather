package com.centralweather.utility;

import com.google.gson.TypeAdapterFactory;

import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * Created by Amber_Chen on 2020-03-18.
 */

@GsonTypeAdapterFactory

public abstract class RetrofitGsonTypeAdapterFactory implements TypeAdapterFactory {
    public static RetrofitGsonTypeAdapterFactory create() {
        return new AutoValueGson_RetrofitGsonTypeAdapterFactory();
    }
}