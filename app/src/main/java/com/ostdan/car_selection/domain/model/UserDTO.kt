package com.ostdan.car_selection.domain.model

import com.google.gson.annotations.SerializedName

data class UserDTO (
    val userId: String,
    val name: String,
    val password: String,
    //val sessions: MutableList<CheckSession> = mutableListOf(),
    val role: RoleDTO
)