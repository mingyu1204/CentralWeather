package com.centralweather.domain.databean;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class WeatherResponse {

	@SerializedName("result")
	public abstract Result result();

	@SerializedName("records")
	public abstract Records records();

	@SerializedName("success")
	public abstract String success();

	public static TypeAdapter<WeatherResponse> typeAdapter(Gson gson) {
		return new AutoValue_WeatherResponse.GsonTypeAdapter(gson);
	}
}