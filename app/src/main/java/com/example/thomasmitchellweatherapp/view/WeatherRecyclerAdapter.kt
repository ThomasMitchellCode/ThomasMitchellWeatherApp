package com.example.thomasmitchellweatherapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thomasmitchellweatherapp.databinding.WeatherSummaryListItemBinding
import com.example.thomasmitchellweatherapp.model.CityWeatherItem

class WeatherRecyclerAdapter(
    private val forecast: MutableList<CityWeatherItem> = mutableListOf(),
    private val openDetails: (CityWeatherItem) -> Unit
): RecyclerView.Adapter<WeatherRecyclerAdapter.WeatherViewHolder>() {

    inner class WeatherViewHolder(
        private val binding: WeatherSummaryListItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(weatherItem: CityWeatherItem) {
            binding.tvDetailsWeatherDescription.text = weatherItem.getDetailedDescription()
            binding.tvTemperature.text = weatherItem.getTemperature()

            binding.root.setOnClickListener {
                openDetails(weatherItem)
            }
        }
    }

    fun setForecast(list: List<CityWeatherItem>) {
        forecast.clear()
        forecast.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(
            WeatherSummaryListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(forecast[position])
    }

    override fun getItemCount(): Int {
        return forecast.size
    }
}