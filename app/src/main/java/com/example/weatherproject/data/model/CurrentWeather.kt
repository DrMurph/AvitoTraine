package com.example.weatherproject.data.model


import com.example.weatherproject.domain.model.DomainWeather
import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("main")
    val main: Main,
    @SerializedName("name")
    val name: String,
    @SerializedName("weather")
    val weather: List<Weather>
)
fun CurrentWeather.toDomain() : DomainWeather{

    return DomainWeather(
        lat = coord.lat,
        lon = coord.lon,
        name = name,
        humidity = main.humidity,
        pressure = main.pressure,
        temp = main.temp,
        weather = weather
    )
}