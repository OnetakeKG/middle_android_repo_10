package ru.yandex.buggyweatherapp.weather_components.domain.api

import kotlinx.coroutines.flow.Flow
import ru.yandex.buggyweatherapp.weather_components.domain.models.WeatherData
import ru.yandex.buggyweatherapp.utils.WeatherResult
import ru.yandex.buggyweatherapp.weather_components.data.dto.Request

internal interface WeatherRepository {
    suspend fun getCurrentWeather(request: Request.CurrentWeather): Flow<WeatherResult<WeatherData>>
    suspend fun getWeatherByCity(request: Request.WeatherByCity) : Flow<WeatherResult<WeatherData>>
}