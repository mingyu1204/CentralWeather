package com.centralweather.presentation.main;

import com.centralweather.R;
import com.centralweather.databinding.WeatherListItemBinding;
import com.centralweather.domain.entity.WeatherTemperatureInfo;
import com.centralweather.presentation.detail.WeatherDetailViewModel;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Amber_Chen on 2020-03-20.
 */
public class WeatherItemAdapter extends RecyclerView.Adapter<WeatherItemAdapter.ViewHolder> {

    private OnItemClickListener onItemClickListener;
    private List<WeatherTemperatureInfo> weatherTemperatureInfos = new ArrayList<>();
    private Activity activity;


    public interface OnItemClickListener {
        void OnItemClick(WeatherTemperatureInfo weatherTemperatureInfo);
    }

    public WeatherItemAdapter() {


    }

    public void setWeatherTemperatureInfos(List<WeatherTemperatureInfo> weatherTemperatureInfos) {
        this.weatherTemperatureInfos = weatherTemperatureInfos;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WeatherListItemBinding weatherListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.weather_list_item,
                parent, false);
        return new ViewHolder(weatherListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WeatherDetailViewModel viewModel = new WeatherDetailViewModel();
        holder.bindDeviceItem(viewModel, weatherTemperatureInfos.get(position));

    }

    @Override
    public int getItemCount() {
        return weatherTemperatureInfos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        WeatherListItemBinding weatherListItemBinding;
        WeatherTemperatureInfo weatherTemperatureInfo;

        public ViewHolder(WeatherListItemBinding weatherListItemBinding) {
            super(weatherListItemBinding.getRoot());
            this.weatherListItemBinding = weatherListItemBinding;
            ButterKnife.bind(this, weatherListItemBinding.getRoot());

        }

        void bindDeviceItem(WeatherDetailViewModel weatherDetailViewModel, WeatherTemperatureInfo weatherTemperatureInfo) {
            this.weatherTemperatureInfo = weatherTemperatureInfo;
            weatherListItemBinding.setViewModel(weatherDetailViewModel);
            weatherDetailViewModel.updateUi(weatherTemperatureInfo);
        }

        @OnClick({R.id.tvStartTime, R.id.tvEndTime, R.id.tvTemperature})
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.tvStartTime:
                case R.id.tvEndTime:
                case R.id.tvTemperature:
                    if (null != onItemClickListener) {
                        onItemClickListener.OnItemClick(weatherTemperatureInfo);
                    }
                    break;
            }
        }


    }
}
