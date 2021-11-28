package com.example.weatherproject.domain

import com.example.weatherproject.data.api.WeatherService
import com.example.weatherproject.data.model.CurrentWeather
import com.example.weatherproject.domain.model.DomainWeather


interface WeatherRepository {
    suspend fun getCurrentWeather(city : String) : DomainWeather

}