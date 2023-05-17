package com.ostdan.car_selection.domain.model

data class User (
    val userId: String,
    val name: String,
    val password: String,

    val sessions: MutableList<CheckSessionDTO> = mutableListOf(),
)