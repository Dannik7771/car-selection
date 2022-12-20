package com.ostdan.car_selection.data.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StepResponse (
    @SerialName("stepId")
    val stepId: String? = null,
    @SerialName("stepImageList")
    val stepImageList: ArrayList<StepImageResponse>? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("descriptionWarning")
    val description_warning: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("result")
    val result: String? = null
)