package ru.yandex.buggyweatherapp.weather_components.data.impl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import ru.yandex.buggyweatherapp.weather_components.domain.models.WeatherData
import ru.yandex.buggyweatherapp.utils.WeatherResult
import ru.yandex.buggyweatherapp.utils.WeatherResult.Success
import ru.yandex.buggyweatherapp.weather_components.data.api.NetworkClient
import ru.yandex.buggyweatherapp.weather_components.data.converter.WeatherDataConverter
import ru.yandex.buggyweatherapp.weather_components.data.dto.Request
import ru.yandex.buggyweatherapp.weather_components.data.dto.Response
import ru.yandex.buggyweatherapp.weather_components.data.dto.ResponseCode
import ru.yandex.buggyweatherapp.weather_components.data.dto.WeatherDataDto
import ru.yandex.buggyweatherapp.weather_components.domain.api.WeatherRepository
import ru.yandex.buggyweatherapp.weather_components.domain.models.RequestError
import javax.inject.Inject

internal class WeatherRepositoryImpl @Inject constructor(
    val networkClient: NetworkClient,
    val weatherDataConverter: WeatherDataConverter
) : WeatherRepository {
    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun getCurrentWeather(request: Request.CurrentWeather): Flow<WeatherResult<WeatherData>> =
        flow {
            val result = networkClient.doRequest(request)
            emit(result)
        }.flatMapConcat {
            handleResponse(it)
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun getWeatherByCity(request: Request.WeatherByCity): Flow<WeatherResult<WeatherData>> =
        flow {
            val result = networkClient.doRequest(request)
            emit(result)
        }.flatMapConcat {
            handleResponse(it)
        }

    private fun handleResponse(result: Response): Flow<WeatherResult<WeatherData>> = flow {
        when (result.resultCode) {
            ResponseCode.Success.code -> {
                emit(Success(weatherDataConverter.mapToWeatherData(result as WeatherDataDto)))
            }

            ResponseCode.ConnectionFailed.code -> {
                emit(WeatherResult.Error(RequestError.Connection))
            }

            ResponseCode.ServerFailed.code -> {
                emit(WeatherResult.Error(RequestError.Server))
            }

            ResponseCode.SearchFail.code -> {
                emit(WeatherResult.Error(RequestError.Search))
            }

            else -> {
                emit(WeatherResult.Error(RequestError.Other))
            }
        }
    }
}