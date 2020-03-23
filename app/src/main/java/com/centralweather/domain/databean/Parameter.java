package com.centralweather.domain.databean;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class Parameter{

	@SerializedName("parameterName")
	public abstract String parameterName();

	@SerializedName("parameterUnit")
	public abstract String parameterUnit();

	public static TypeAdapter<Parameter> typeAdapter(Gson gson) {
		return new AutoValue_Parameter.GsonTypeAdapter(gson);
	}
}