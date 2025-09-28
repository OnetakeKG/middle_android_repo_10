package ru.yandex.buggyweatherapp.domain.impl

import kotlinx.coroutines.flow.Flow
import ru.yandex.buggyweatherapp.disposition.domain.api.LocationInteractor
import ru.yandex.buggyweatherapp.domain.api.LocationRepository
import ru.yandex.buggyweatherapp.domain.models.Location
import javax.inject.Inject

internal class LocationInteractorImpl @Inject constructor(
    private val locationRepository: LocationRepository
): LocationInteractor {
    override suspend fun getCurrentLocation(): Flow<Location?> {
        return locationRepository.getCurrentLocation()
    }

    override suspend fun getCityNameFromLocation(location: Location): String? {
        return locationRepository.getCityNameFromLocation(location)
    }
}