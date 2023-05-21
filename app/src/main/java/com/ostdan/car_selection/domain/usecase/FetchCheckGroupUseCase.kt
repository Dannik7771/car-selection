package com.ostdan.car_selection.domain.usecase

import android.util.Log
import com.ostdan.car_selection.domain.model.CheckGroupDTO
import com.ostdan.car_selection.domain.repository.CheckGroupRepository
import kotlinx.coroutines.flow.Flow

class FetchCheckGroupUseCase(
    private val checkGroupRepository: CheckGroupRepository
) {
    operator fun invoke(checkGroupId: String,
                        accessToken: String
    ): Flow<CheckGroupDTO> {
        Log.d("FetchCheckGroup", "invoke")
        return checkGroupRepository.fetchCheckGroup(checkGroupId, accessToken)
    }
}