package com.ostdan.car_selection.data.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StepResponse (
    @SerialName("step_image_list")
    val stepImageList: ArrayList<StepImageResponse>? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("description_warning")
    val description_warning: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("result")
    val result: String? = null
)