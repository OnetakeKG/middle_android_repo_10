package ru.yandex.buggyweatherapp.disposition.domain.api

import kotlinx.coroutines.flow.Flow
import ru.yandex.buggyweatherapp.domain.models.Location

internal interface LocationInteractor {
    suspend fun getCurrentLocation() : Flow<Location?>
    suspend fun getCityNameFromLocation(location: Location): String?
}