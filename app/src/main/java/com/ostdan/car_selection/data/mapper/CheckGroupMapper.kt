package com.ostdan.car_selection.data.mapper

import com.ostdan.car_selection.data.model.remote.CheckGroupResponse
import com.ostdan.car_selection.domain.model.CheckGroupDTO
import javax.inject.Inject

class CheckGroupMapper @Inject constructor() {
    fun map(response: CheckGroupResponse): CheckGroupDTO =
        CheckGroupDTO(
            checkGroupId = response.checkGroupId,
            name = response.name,
            completion = response.completion,
            image = response.image,
            categories = response.categories.map{map(it)}
        )

    fun map(category: CheckGroupResponse.Category) : CheckGroupDTO.CategoryDTO =
        CheckGroupDTO.CategoryDTO(
            category = category.category,
            checks = category.checks.map{map(it)}
        )

    fun map(check: CheckGroupResponse.Category.Check) : CheckGroupDTO.CategoryDTO.CheckDTO =
        CheckGroupDTO.CategoryDTO.CheckDTO(
            checkId = check.checkId,
            title = check.title,
            status = check.status,
            image = check.image
        )
}