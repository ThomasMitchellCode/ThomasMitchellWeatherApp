package com.example.thomasmitchellweatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thomasmitchellweatherapp.model.CityWeatherResponse
import com.example.thomasmitchellweatherapp.repository.WeatherRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel(private val repositoryImpl : WeatherRepositoryImpl): ViewModel() {

    private val _forecast = MutableLiveData<CityWeatherResponse>()
    val forecast : LiveData<CityWeatherResponse> get() = _forecast

    fun getForecast(city: String?) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositoryImpl.getWeather(city)
            _forecast.postValue(response)
        }
    }
}