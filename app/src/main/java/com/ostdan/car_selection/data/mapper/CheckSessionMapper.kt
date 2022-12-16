package com.ostdan.car_selection.data.mapper

import com.ostdan.car_selection.data.model.remote.CheckSessionResponse
import com.ostdan.car_selection.domain.model.CheckSessionDTO
import javax.inject.Inject

class CheckSessionMapper @Inject constructor(
    private val checkGroupMapper: CheckGroupMapper
) {
    fun map(response: CheckSessionResponse): CheckSessionDTO =
        CheckSessionDTO(
            checkGroupList = response.checkGroupList?.map{checkGroupMapper.map(it)}.orEmpty(),
            govNumber = response.govNumber.orEmpty(),
            vin = response.vin.orEmpty(),
            searchSuccessful = response.searchSuccessful ?: false
        )
}