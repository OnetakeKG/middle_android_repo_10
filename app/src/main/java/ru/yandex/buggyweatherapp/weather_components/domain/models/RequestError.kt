package ru.yandex.buggyweatherapp.weather_components.domain.models

sealed interface RequestError {
    data object Connection: RequestError
    data object Search: RequestError
    data object Server: RequestError
    data object Other: RequestError
    data object EmptyRequest: RequestError
    data object UnableLocation: RequestError
}