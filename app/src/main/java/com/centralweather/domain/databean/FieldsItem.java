package com.centralweather.domain.databean;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class FieldsItem{

	@SerializedName("id")
	public abstract String id();

	@SerializedName("type")
	public abstract String type();

	public static TypeAdapter<FieldsItem> typeAdapter(Gson gson) {
		return new AutoValue_FieldsItem.GsonTypeAdapter(gson);
	}
}