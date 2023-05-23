package com.ostdan.car_selection.domain.usecase

import android.util.Log
import com.ostdan.car_selection.domain.model.CheckDTO
import com.ostdan.car_selection.domain.repository.CheckRepository
import kotlinx.coroutines.flow.Flow

class UpdateAnswerUseCase(
    private val checkRepository: CheckRepository
) {
    operator fun invoke(checkId: String,
                        stepId: String,
                        answerId: String,
                        selected: Boolean,
                        accessToken: String
    ): Flow<CheckDTO> {
        Log.d("UpdateAnswer", "invoke")
        return checkRepository.updateAnswer(checkId, stepId, answerId, selected, accessToken)
    }
}