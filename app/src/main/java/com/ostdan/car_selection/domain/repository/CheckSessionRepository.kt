package com.ostdan.car_selection.domain.repository

import com.ostdan.car_selection.domain.model.CheckSessionDTO
import kotlinx.coroutines.flow.Flow

interface CheckSessionRepository {
    fun fetchCheckSession(govNumber: String, vin: String, accessToken: String): Flow<CheckSessionDTO>
}