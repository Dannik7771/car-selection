package com.ostdan.car_selection.data.repository

import com.ostdan.car_selection.data.mapper.CheckGroupMapper
import com.ostdan.car_selection.data.model.remote.service.CheckGroupService
import com.ostdan.car_selection.domain.model.CheckGroupDTO
import com.ostdan.car_selection.domain.repository.CheckGroupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CheckGroupRepositoryImpl @Inject constructor(
    private val checkGroupService: CheckGroupService,
    private val checkGroupMapper: CheckGroupMapper
) : CheckGroupRepository {
    override fun fetchCheckGroup(checkGroupId: String, accessToken: String): Flow<CheckGroupDTO> {
        return flow {
            checkGroupService.getCheckGroupById(checkGroupId, accessToken).collect { resource ->
                if (resource is Resource.Success) {
                    emit(
                        checkGroupMapper.map(resource.data)
                    )
                }
                else if (resource is Resource.Error) {
                    println(resource.errorData)
                }
            }
        }
    }
}