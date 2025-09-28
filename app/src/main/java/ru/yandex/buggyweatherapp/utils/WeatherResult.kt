package ru.yandex.buggyweatherapp.utils

import ru.yandex.buggyweatherapp.weather_components.domain.models.RequestError

sealed class WeatherResult<T>(
    val data: T? = null,
    val code: RequestError? = null
) {
    class Success<T>(data: T) : WeatherResult<T>(data = data)
    class Error<T>(code: RequestError?) : WeatherResult<T>(code = code)
}