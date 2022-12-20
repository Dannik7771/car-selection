package com.ostdan.car_selection.data.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StepImageResponse (
    @SerialName("stepImageId")
    val stepImageId: String? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("sign")
    val sign: String? = null,
    @SerialName("status")
    val status: String? = null // for moderation
)