package com.ostdan.car_selection.data.model.remote.service

import com.ostdan.car_selection.data.model.remote.UserResponse
import com.ostdan.car_selection.data.repository.Resource
import com.ostdan.car_selection.domain.model.UserDTO
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("/user")
    fun postUser(
        @Body userDTO: UserDTO
    ): Flow<Resource<UserResponse>>
}