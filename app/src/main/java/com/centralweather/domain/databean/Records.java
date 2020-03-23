package com.centralweather.domain.databean;

import java.util.List;
import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class Records{

	@SerializedName("datasetDescription")
	public abstract String datasetDescription();

	@SerializedName("location")
	public abstract List<LocationItem> location();

	public static TypeAdapter<Records> typeAdapter(Gson gson) {
		return new AutoValue_Records.GsonTypeAdapter(gson);
	}
}