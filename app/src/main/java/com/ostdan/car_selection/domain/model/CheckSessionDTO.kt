package com.ostdan.car_selection.domain.model

data class CheckSessionDTO(
    val checkGroupPreviewList: List<CheckGroupPreviewDTO>,
    val govNumber: String,
    val vin: String,
    val searchSuccessful: Boolean
)