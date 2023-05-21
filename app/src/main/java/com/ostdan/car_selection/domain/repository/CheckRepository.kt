package com.ostdan.car_selection.domain.repository

import com.ostdan.car_selection.domain.model.CheckDTO
import kotlinx.coroutines.flow.Flow

interface CheckRepository {
    fun fetchCheck(checkId: String, accessToken: String): Flow<CheckDTO>
}