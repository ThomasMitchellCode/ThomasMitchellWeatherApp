package com.example.thomasmitchellweatherapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


// need variable for :
/*
        weather -> main
        weather -> description
        weather -> icon
        main -> temp
        main -> feels_like
        name        (city name)
 */

data class CityWeatherResponse(
    val result: List<CityWeatherItem>
)

@Parcelize
data class CityWeatherItem(
    val name : String,
    val weather : @RawValue WeatherDetails,
    val main : @RawValue TempDetails
): Parcelable {

    fun getCity(): String {
        return this.name
    }

    fun getDescription(): String {
        return this.weather.main
    }

    fun getDetailedDescription(): String {
        return this.weather.description
    }

    fun getIcon(): String {
        return weather.icon
    }

    fun getTemperature(): String {
        return main.temp
    }

    fun getFeelsLike(): String {
        return main.feels_like
    }
}


data class WeatherDetails(
    val main : String,
    val description : String,
    val icon : String
)


data class TempDetails(
    val temp : String,
    val feels_like : String
)
