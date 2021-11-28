package com.example.weatherproject.data

import com.example.weatherproject.data.api.WeatherService
import com.example.weatherproject.data.model.CurrentWeather
import com.example.weatherproject.data.model.toDomain
import com.example.weatherproject.domain.WeatherRepository
import com.example.weatherproject.domain.model.DomainWeather
import java.net.UnknownHostException
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val service : WeatherService) : WeatherRepository {

    override suspend fun getCurrentWeather(city: String): DomainWeather {
        return try {
            val response = service.getCurrentWeather(city)
            response.body()!!.toDomain()
        }catch (e : UnknownHostException){
            TODO()
        }
    }
}