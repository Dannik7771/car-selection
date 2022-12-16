package com.ostdan.car_selection.data.mapper

import com.ostdan.car_selection.data.model.remote.CheckResponse
import com.ostdan.car_selection.domain.model.CheckDTO
import javax.inject.Inject

class CheckMapper @Inject constructor(
    private val stepMapper: StepMapper
) {
    fun map(response: CheckResponse) : CheckDTO =
        CheckDTO(
            stepList = response.stepList?.map{stepMapper.map(it)}.orEmpty(),
            title = response.title.orEmpty(),
            status = response.status.orEmpty(),
            description = response.description.orEmpty(),
            description_warning = response.description_warning.orEmpty(),
            description_alert = response.description_alert.orEmpty(),
            category = response.category.orEmpty(),
            images = response.images.orEmpty()
        )
}