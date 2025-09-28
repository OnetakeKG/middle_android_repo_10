package ru.yandex.buggyweatherapp.weather_components.data.api

import ru.yandex.buggyweatherapp.weather_components.data.dto.Request
import ru.yandex.buggyweatherapp.weather_components.data.dto.Response

internal interface NetworkClient {
    suspend fun doRequest(request: Request): Response
}