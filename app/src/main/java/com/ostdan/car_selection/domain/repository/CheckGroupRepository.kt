package com.ostdan.car_selection.domain.repository

import com.ostdan.car_selection.domain.model.CheckGroupDTO
import kotlinx.coroutines.flow.Flow

interface CheckGroupRepository {
    fun fetchCheckGroup(checkGroupId: String, accessToken: String): Flow<CheckGroupDTO>
}