package com.ostdan.car_selection.data.mapper

import com.ostdan.car_selection.data.model.remote.UserResponse
import com.ostdan.car_selection.domain.model.UserDTO
import javax.inject.Inject

class UserMapper @Inject constructor() {
    fun map(response: UserResponse): UserDTO =
        UserDTO(
            userId = response.userId,
            name = response.name,
            password = response.password,
            role = response.role
        )
}