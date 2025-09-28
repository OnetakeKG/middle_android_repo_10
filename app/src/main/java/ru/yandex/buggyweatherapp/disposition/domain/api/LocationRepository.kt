package ru.yandex.buggyweatherapp.domain.api

import kotlinx.coroutines.flow.Flow
import ru.yandex.buggyweatherapp.domain.models.Location

internal interface LocationRepository {
    suspend fun getCurrentLocation() : Flow<Location?>
    suspend fun getCityNameFromLocation(location: Location): String?
}