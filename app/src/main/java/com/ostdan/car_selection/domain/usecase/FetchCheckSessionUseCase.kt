package com.ostdan.car_selection.domain.usecase

import android.util.Log
import com.ostdan.car_selection.domain.model.CheckSessionDTO
import com.ostdan.car_selection.domain.repository.CarCheckRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchCheckSessionUseCase @Inject constructor(
    private val carCheckRepository: CarCheckRepository
) {
    operator fun invoke(
        govNumber: String,
        vin: String,
        userId: String
    ): Flow<CheckSessionDTO> {
        Log.d("FetchCheckSession", "invoke")
        return carCheckRepository.fetchCheckSession(govNumber, vin, userId)
    }
}