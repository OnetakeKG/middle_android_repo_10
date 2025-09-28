package ru.yandex.buggyweatherapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.yandex.buggyweatherapp.disposition.data.impl.LocationRepositoryImpl
import ru.yandex.buggyweatherapp.disposition.domain.api.LocationInteractor
import ru.yandex.buggyweatherapp.domain.api.LocationRepository
import ru.yandex.buggyweatherapp.domain.impl.LocationInteractorImpl

@Module
@InstallIn(SingletonComponent::class)
internal interface LocationModule {

    @Binds
    fun bindLocationRepository(locationRepository: LocationRepositoryImpl): LocationRepository

    @Binds
    fun bindLocationInteractor(locationInteractor: LocationInteractorImpl): LocationInteractor
}