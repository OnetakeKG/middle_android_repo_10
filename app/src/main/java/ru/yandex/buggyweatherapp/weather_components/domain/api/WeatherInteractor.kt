package ru.yandex.buggyweatherapp.weather_components.domain.api

import kotlinx.coroutines.flow.Flow
import ru.yandex.buggyweatherapp.weather_components.domain.models.WeatherData
import ru.yandex.buggyweatherapp.weather_components.data.dto.Request
import ru.yandex.buggyweatherapp.weather_components.domain.models.RequestError

internal interface WeatherInteractor {
    suspend fun getCurrentWeather(request: Request.CurrentWeather): Flow<Pair<WeatherData?, RequestError?>>
    suspend fun getWeatherByCity(request: Request.WeatherByCity) : Flow<Pair<WeatherData?, RequestError?>>
}