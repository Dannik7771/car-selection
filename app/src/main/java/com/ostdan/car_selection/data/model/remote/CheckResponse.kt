package com.ostdan.car_selection.data.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CheckResponse (
    @SerialName("checkId")
    val checkId: String? = null,
    @SerialName("stepList")
    val stepList: ArrayList<StepResponse>? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("status")
    val status: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("descriptionWarning")
    val descriptionWarning: String? = null,
    @SerialName("descriptionAlert")
    val descriptionAlert: String? = null,
    @SerialName("category")
    val category: String? = null,
    @SerialName("images")
    val images: ArrayList<String>? = null
)