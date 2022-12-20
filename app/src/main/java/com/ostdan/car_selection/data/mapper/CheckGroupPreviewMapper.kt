package com.ostdan.car_selection.data.mapper

import com.ostdan.car_selection.data.model.remote.CheckGroupPreviewResponse
import com.ostdan.car_selection.domain.model.CheckGroupPreviewDTO
import javax.inject.Inject

class CheckGroupPreviewMapper @Inject constructor(
    private val checkGroupMapper: CheckGroupMapper
) {
    fun map(response: CheckGroupPreviewResponse): CheckGroupPreviewDTO =
        CheckGroupPreviewDTO(
            type = response.type.orEmpty(),
            checkGroupList = response.checkGroupList?.map{checkGroupMapper.map(it)}.orEmpty()
        )
}