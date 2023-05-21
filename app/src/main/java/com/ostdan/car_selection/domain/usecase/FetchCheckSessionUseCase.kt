package com.ostdan.car_selection.domain.usecase

import android.util.Log
import com.ostdan.car_selection.domain.model.CheckSessionDTO
import com.ostdan.car_selection.domain.repository.CheckSessionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchCheckSessionUseCase @Inject constructor(
    private val checkSessionRepository: CheckSessionRepository
) {
    operator fun invoke(
        govNumber: String,
        vin: String,
        accessToken: String
    ): Flow<CheckSessionDTO> {
        Log.d("FetchCheckSession", "invoke")
        return checkSessionRepository.fetchCheckSession(govNumber, vin, accessToken)
    }
}