package com.ostdan.car_selection.data.mapper

import com.ostdan.car_selection.data.model.remote.StepResponse
import com.ostdan.car_selection.domain.model.StepDTO
import javax.inject.Inject

class StepMapper @Inject constructor(
    private val stepImageMapper: StepImageMapper
) {
    fun map(response: StepResponse) : StepDTO =
        StepDTO(
            stepImageList = response.stepImageList?.map{stepImageMapper.map(it)}.orEmpty(),
            title = response.title.orEmpty(),
            description = response.description.orEmpty(),
            description_warning = response.description_warning.orEmpty(),
            type = response.type.orEmpty(),
            result = response.result.orEmpty()
        )
}