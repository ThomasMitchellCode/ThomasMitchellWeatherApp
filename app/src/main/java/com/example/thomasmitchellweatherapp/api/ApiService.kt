package com.example.thomasmitchellweatherapp.api

import com.example.thomasmitchellweatherapp.model.CityWeatherResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

// d9e11362e9184772d1b3b588770b0abb     OpenWeatherApiKey
// baseUrl      api.openweathermap.org
// ApiCall Url      api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=d9e11362e9184772d1b3b588770b0abb

interface ApiService {

    @GET("data/2.5/weather?q=London,uk&APPID=d9e11362e9184772d1b3b588770b0abb")
    suspend fun getCityWeather(
        @Query("result") name: String? = null
    ) : Response<CityWeatherResponse>

    companion object {
        private var instance: ApiService? = null
        fun getApiService(): ApiService {
            if (instance == null) {
                instance = Retrofit.Builder()
                    .baseUrl("api.openweathermap.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }
            return instance!!
        }
    }
}