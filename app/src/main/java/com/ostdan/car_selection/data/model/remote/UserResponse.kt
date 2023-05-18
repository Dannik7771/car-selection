package com.ostdan.car_selection.data.model.remote

import com.google.gson.annotations.SerializedName
import com.ostdan.car_selection.domain.model.RoleDTO
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse (
    @SerializedName("userId") val userId: String,
    @SerializedName("name") val name: String,
    @SerializedName("password") val password: String,

    //val sessions: MutableList<CheckSession> = mutableListOf(),

    @SerializedName("role") val role: RoleDTO
)