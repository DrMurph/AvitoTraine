package com.example.weatherproject.domain.model

import com.example.weatherproject.data.model.Coord
import com.example.weatherproject.data.model.Main
import com.example.weatherproject.data.model.Weather
import com.google.gson.annotations.SerializedName

data class DomainWeather(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("weather")
    val weather: List<Weather>
)
