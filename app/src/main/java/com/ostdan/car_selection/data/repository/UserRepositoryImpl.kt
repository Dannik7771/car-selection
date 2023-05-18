package com.ostdan.car_selection.data.repository

import com.ostdan.car_selection.data.mapper.UserMapper
import com.ostdan.car_selection.data.model.remote.service.UserService
import com.ostdan.car_selection.domain.model.UserDTO
import com.ostdan.car_selection.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService,
    private val userMapper: UserMapper
): UserRepository {
    override fun fetchUser(userDTO: UserDTO): Flow<UserDTO> {
        return flow {
            userService.postUser(userDTO).collect { resource ->
                if (resource is Resource.Success) {
                    emit(
                        userMapper.map(resource.data)
                    )
                } else if (resource is Resource.Error) {
                    println(resource.errorData)
                }
            }
        }
    }
}