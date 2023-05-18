package com.ostdan.car_selection.domain.repository

import com.ostdan.car_selection.data.model.remote.UserResponse
import com.ostdan.car_selection.domain.model.UserDTO
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun fetchUser(userDTO: UserDTO): Flow<UserDTO>
}