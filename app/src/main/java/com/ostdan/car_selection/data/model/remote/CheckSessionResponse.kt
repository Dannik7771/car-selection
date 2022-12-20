package com.ostdan.car_selection.data.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
class CheckSessionResponse (
    @SerialName("checkSessionId")
    val checkSessionId: String? = null,
    @SerialName("checkGroupPreviewList")
    val checkGroupPreviewList: List<CheckGroupPreviewResponse>? = null,
    @SerialName("govNumber")
    val govNumber: String? = null,
    @SerialName("vin")
    val vin: String? = null,
    @SerialName("searchSuccessful")
    val searchSuccessful: Boolean? = null
)