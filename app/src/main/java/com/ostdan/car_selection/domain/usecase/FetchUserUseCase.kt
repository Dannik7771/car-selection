package com.ostdan.car_selection.domain.usecase

import android.util.Log
import com.ostdan.car_selection.domain.model.UserDTO
import com.ostdan.car_selection.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(
        userDTO: UserDTO
    ): Flow<UserDTO> {
        Log.d("FetchUser", "invoke")
        return userRepository.fetchUser(userDTO)
    }
}