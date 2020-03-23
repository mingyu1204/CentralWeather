package com.centralweather.domain.databean;

import java.util.List;
import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class LocationItem{

	@SerializedName("locationName")
	public abstract String locationName();

	@SerializedName("weatherElement")
	public abstract List<WeatherElementItem> weatherElement();

	public static TypeAdapter<LocationItem> typeAdapter(Gson gson) {
		return new AutoValue_LocationItem.GsonTypeAdapter(gson);
	}
}