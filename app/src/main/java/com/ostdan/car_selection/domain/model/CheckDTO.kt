package com.ostdan.car_selection.domain.model

data class CheckDTO (
    val stepList: List<StepDTO>,
    val title: String,
    val status: String,
    val description: String,
    val description_warning: String,
    val description_alert: String,
    val category: String,
    val images: List<String>
)