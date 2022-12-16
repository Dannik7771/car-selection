package com.ostdan.car_selection.data.repository

import com.ostdan.car_selection.data.mapper.CheckSessionMapper
import com.ostdan.car_selection.data.model.remote.service.CarCheckService
import com.ostdan.car_selection.domain.model.CheckSessionDTO
import com.ostdan.car_selection.domain.repository.CarCheckRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CarCheckRepositoryImpl @Inject constructor(
    private val carCheckService: CarCheckService,
    private val checkSessionMapper: CheckSessionMapper
): CarCheckRepository {
    override fun fetchCheckSession(
        govNumber: String,
        vin: String,
        accessToken: String
    ): Flow<CheckSessionDTO> {
        return flow {
            carCheckService.getCheckSession(vin, govNumber, accessToken).collect { response ->
                checkSessionMapper.map(response)
            }
        }
    }
}