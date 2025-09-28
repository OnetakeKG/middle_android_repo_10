package ru.yandex.buggyweatherapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.yandex.buggyweatherapp.weather_components.data.WeatherNetworkClient
import ru.yandex.buggyweatherapp.weather_components.data.api.NetworkClient
import ru.yandex.buggyweatherapp.weather_components.data.impl.WeatherRepositoryImpl
import ru.yandex.buggyweatherapp.weather_components.domain.api.WeatherInteractor
import ru.yandex.buggyweatherapp.weather_components.domain.api.WeatherRepository
import ru.yandex.buggyweatherapp.weather_components.domain.impl.WeatherInteractorImpl

@Module
@InstallIn(SingletonComponent::class)
internal interface WeatherModule {

    @Binds
    fun bindNetworkClient(weatherNetworkClient: WeatherNetworkClient): NetworkClient

    @Binds
    fun bindWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository

    @Binds
    fun bindWeatherInteractor(weatherInteractorImpl: WeatherInteractorImpl): WeatherInteractor
}