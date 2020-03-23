package com.centralweather.domain.databean;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;


@AutoValue
public abstract class TimeItem{

	@SerializedName("parameter")
	public abstract Parameter parameter();

	@SerializedName("startTime")
	public abstract String startTime();

	@SerializedName("endTime")
	public abstract String endTime();

	public static TypeAdapter<TimeItem> typeAdapter(Gson gson) {
		return new AutoValue_TimeItem.GsonTypeAdapter(gson);
	}
}