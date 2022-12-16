package com.ostdan.car_selection.data.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CheckResponse (
    @SerialName("step_list")
    val stepList: ArrayList<StepResponse>? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("status")
    val status: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("description_warning")
    val description_warning: String? = null,
    @SerialName("description_alert")
    val description_alert: String? = null,
    @SerialName("category")
    val category: String? = null,
    @SerialName("images")
    val images: ArrayList<String>? = null
)