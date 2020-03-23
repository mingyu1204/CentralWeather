package com.centralweather.domain.entity;

import java.io.Serializable;

/**
 * Created by Amber_Chen on 2020-03-20.
 */
public class WeatherTemperatureInfo implements Serializable {
    private String tartTime;
    private String endTime;
    private String parameterName;
    private String parameterUnit;

    public WeatherTemperatureInfo() {
    }

    public WeatherTemperatureInfo(Builder builder) {
        tartTime = builder.tartTime;
        endTime = builder.endTime;
        parameterName = builder.parameterName;
        parameterUnit = builder.parameterUnit;
    }

    public String getTartTime() {
        return tartTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getParameterName() {
        return parameterName;
    }

    public String getParameterUnit() {
        return parameterUnit;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private String tartTime;
        private String endTime;
        private String parameterName;
        private String parameterUnit;

        private Builder() {
        }

        public Builder tartTime(String val) {
            tartTime = val;
            return this;
        }

        public Builder endTime(String val) {
            endTime = val;
            return this;
        }

        public Builder parameterName(String val) {
            parameterName = val;
            return this;
        }

        public Builder parameterUnit(String val) {
            parameterUnit = val;
            return this;
        }

        public WeatherTemperatureInfo build() {
            return new WeatherTemperatureInfo(this);
        }
    }
}
