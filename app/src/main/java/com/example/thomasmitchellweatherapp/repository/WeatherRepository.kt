package com.example.thomasmitchellweatherapp.repository

import com.example.thomasmitchellweatherapp.api.ApiService
import com.example.thomasmitchellweatherapp.model.CityWeatherResponse

interface WeatherRepository {
    suspend fun getWeather(city: String?) : CityWeatherResponse
}

class WeatherRepositoryImpl (
    private val service: ApiService = ApiService.getApiService(),
    private val city: String? = null
    ): WeatherRepository {

    // need to come back to this and get it right
        override suspend fun getWeather(city: String?): CityWeatherResponse {
            val response = service.getCityWeather(city)

        if (response.isSuccessful) {
            return response.body()!!
        }

        return CityWeatherResponse(emptyList())
        }
    }