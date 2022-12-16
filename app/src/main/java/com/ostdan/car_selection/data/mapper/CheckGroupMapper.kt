package com.ostdan.car_selection.data.mapper

import com.ostdan.car_selection.data.model.remote.CheckGroupResponse
import com.ostdan.car_selection.domain.model.CheckGroupDTO
import javax.inject.Inject

class CheckGroupMapper @Inject constructor(
    private val checkMapper: CheckMapper
) {
    fun map(response: CheckGroupResponse): CheckGroupDTO =
        CheckGroupDTO(
            checkList = response.checkList?.map{checkMapper.map(it)}.orEmpty(),
            name = response.name.orEmpty(),
            type = response.type.orEmpty(),
            completion = response.completion ?: 0.0f,
            image = response.image.orEmpty()
        )
}