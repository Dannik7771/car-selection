package com.ostdan.car_selection.data.mapper

import com.ostdan.car_selection.data.model.remote.StepImageResponse
import com.ostdan.car_selection.domain.model.StepImageDTO
import javax.inject.Inject

class StepImageMapper @Inject constructor() {
    fun map(response: StepImageResponse) : StepImageDTO =
        StepImageDTO(
            image = response.image.orEmpty(),
            description = response.description.orEmpty(),
            sign = response.sign.orEmpty(),
            status = response.status.orEmpty()
        )
}