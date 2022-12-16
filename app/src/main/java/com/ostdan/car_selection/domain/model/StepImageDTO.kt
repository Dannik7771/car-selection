package com.ostdan.car_selection.domain.model

data class StepImageDTO (
    val image: String,
    val description: String,
    val sign: String,
    val status: String // for moderation
)