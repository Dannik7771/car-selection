package com.ostdan.car_selection.data.repository

import com.ostdan.car_selection.data.mapper.CheckSessionMapper
import com.ostdan.car_selection.data.model.remote.service.CheckSessionService
import com.ostdan.car_selection.domain.model.CheckSessionDTO
import com.ostdan.car_selection.domain.repository.CheckSessionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CheckSessionRepositoryImpl @Inject constructor(
    private val checkSessionService: CheckSessionService,
    private val checkSessionMapper: CheckSessionMapper
): CheckSessionRepository {
    override fun fetchCheckSession(
        govNumber: String,
        vin: String,
        userId: String
    ): Flow<CheckSessionDTO> {
        return flow {
            checkSessionService.getCheckSessionByVin(vin, userId).collect { resource ->
                if (resource is Resource.Success) {
                    emit(
                        checkSessionMapper.map(resource.data)
                    )
                }
                else if (resource is Resource.Error) {
                    println(resource.errorData)
                }
            }
        }
    }
}