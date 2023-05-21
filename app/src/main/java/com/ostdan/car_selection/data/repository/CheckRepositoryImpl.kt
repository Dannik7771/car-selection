package com.ostdan.car_selection.data.repository

import com.ostdan.car_selection.data.mapper.CheckGroupMapper
import com.ostdan.car_selection.data.mapper.CheckMapper
import com.ostdan.car_selection.data.model.remote.service.CheckGroupService
import com.ostdan.car_selection.data.model.remote.service.CheckService
import com.ostdan.car_selection.domain.model.CheckDTO
import com.ostdan.car_selection.domain.repository.CheckRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CheckRepositoryImpl @Inject constructor(
    private val checkService: CheckService,
    private val checkMapper: CheckMapper
) : CheckRepository {
    override fun fetchCheck(checkId: String, accessToken: String): Flow<CheckDTO> {
        return flow {
            checkService.getCheckById(checkId, accessToken).collect { resource ->
                if (resource is Resource.Success) {
                    emit(
                        checkMapper.map(resource.data)
                    )
                }
                else if (resource is Resource.Error) {
                    println(resource.errorData)
                }
            }
        }
    }
}