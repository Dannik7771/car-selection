package com.ostdan.car_selection.domain.model

data class CheckGroupDTO (
    val checkList: List<CheckDTO>,
    val name: String,
    val completion: Float,
    val image: String
)