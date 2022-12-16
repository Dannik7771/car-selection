package com.ostdan.car_selection.domain.model


data class StepDTO (
    val stepImageList: List<StepImageDTO>,
    val title: String,
    val description: String,
    val description_warning: String,
    val type: String,
    val result: String
)