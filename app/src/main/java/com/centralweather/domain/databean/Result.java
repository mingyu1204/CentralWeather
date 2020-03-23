package com.centralweather.domain.databean;

import java.util.List;
import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class Result{

	@SerializedName("resource_id")
	public abstract String resourceId();

	@SerializedName("fields")
	public abstract List<FieldsItem> fields();

	public static TypeAdapter<Result> typeAdapter(Gson gson) {
		return new AutoValue_Result.GsonTypeAdapter(gson);
	}
}