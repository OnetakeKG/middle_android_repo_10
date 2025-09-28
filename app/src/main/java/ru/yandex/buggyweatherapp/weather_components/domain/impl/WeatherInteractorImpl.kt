package ru.yandex.buggyweatherapp.weather_components.domain.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.yandex.buggyweatherapp.weather_components.domain.models.WeatherData
import ru.yandex.buggyweatherapp.utils.WeatherResult
import ru.yandex.buggyweatherapp.weather_components.data.dto.Request
import ru.yandex.buggyweatherapp.weather_components.data.impl.WeatherRepositoryImpl
import ru.yandex.buggyweatherapp.weather_components.domain.api.WeatherInteractor
import ru.yandex.buggyweatherapp.weather_components.domain.models.RequestError
import javax.inject.Inject

internal class WeatherInteractorImpl @Inject constructor(
    private val repository: WeatherRepositoryImpl
) : WeatherInteractor {
    override suspend fun getCurrentWeather(request: Request.CurrentWeather): Flow<Pair<WeatherData?, RequestError?>> {
        return repository.getCurrentWeather(request).map { result ->
            when (result) {
                is WeatherResult.Success -> {
                    Pair(result.data, null)
                }

                is WeatherResult.Error -> {
                    Pair(null, result.code)
                }
            }
        }

    }

    override suspend fun getWeatherByCity(request: Request.WeatherByCity): Flow<Pair<WeatherData?, RequestError?>> {
        return repository.getWeatherByCity(request).map { result ->
            when (result) {
                is WeatherResult.Success -> {
                    Pair(result.data, null)
                }

                is WeatherResult.Error -> {
                    Pair(null, result.code)
                }
            }
        }
    }
}