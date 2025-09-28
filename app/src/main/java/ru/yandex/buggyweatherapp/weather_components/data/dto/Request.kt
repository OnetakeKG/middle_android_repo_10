package ru.yandex.buggyweatherapp.weather_components.data.dto

sealed class Request {
    data class CurrentWeather(
        val latitude: Double,
        val longitude: Double
    ) : Request()

    data class WeatherByCity(
        val cityName: String
    ) : Request()
}