package com.centralweather.domain.databean;

import java.util.List;
import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class WeatherElementItem{

	@SerializedName("time")
	public abstract List<TimeItem> time();

	@SerializedName("elementName")
	public abstract String elementName();

	public static TypeAdapter<WeatherElementItem> typeAdapter(Gson gson) {
		return new AutoValue_WeatherElementItem.GsonTypeAdapter(gson);
	}
}