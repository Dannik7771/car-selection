package com.ostdan.car_selection.domain.usecase

import android.util.Log
import com.ostdan.car_selection.domain.model.CheckDTO
import com.ostdan.car_selection.domain.repository.CheckRepository
import kotlinx.coroutines.flow.Flow

class FetchCheckUseCase(
    private val checkRepository: CheckRepository
) {
    operator fun invoke(checkId: String,
                        accessToken: String
    ): Flow<CheckDTO> {
        Log.d("FetchCheck", "invoke")
        return checkRepository.fetchCheck(checkId, accessToken)
    }
}