package com.ostdan.car_selection.data.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class CheckGroupPreviewResponse (
    @SerialName("checkGroupPreviewId")
    val checkGroupPreviewId: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("checkGroupList")
    val checkGroupList: List<CheckGroupResponse>? = null
)