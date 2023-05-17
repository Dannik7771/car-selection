package com.ostdan.car_selection.data.mapper

import com.ostdan.car_selection.data.model.remote.CheckSessionResponse
import com.ostdan.car_selection.domain.model.CheckSessionDTO
import javax.inject.Inject

class CheckSessionMapper @Inject constructor() {
    fun map(response: CheckSessionResponse): CheckSessionDTO =
        CheckSessionDTO(
            checkSessionId = response.checkSessionId,
            vin = response.vin,
            govNumber = response.govNumber,
            types = response.types.map { map(it) }
        )

    private fun map(type: CheckSessionResponse.Type): CheckSessionDTO.TypeDTO =
        CheckSessionDTO.TypeDTO(
            type = type.type,
            checkGroups = type.checkGroups.map { map(it) }
        )

    private fun map(checkGroup: CheckSessionResponse.Type.CheckGroup): CheckSessionDTO.TypeDTO.CheckGroupDTO =
        CheckSessionDTO.TypeDTO.CheckGroupDTO(
            checkGroupId = checkGroup.checkGroupId,
            name = checkGroup.name,
            image = checkGroup.image
        )
}