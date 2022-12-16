package com.ostdan.car_selection.domain.model

data class CheckSessionDTO(
    val checkGroupList: List<CheckGroupDTO>,
    val govNumber: String,
    val vin: String,
    val searchSuccessful: Boolean
)