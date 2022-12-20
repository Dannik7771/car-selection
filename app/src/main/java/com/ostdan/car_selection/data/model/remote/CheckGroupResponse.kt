package com.ostdan.car_selection.data.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
class CheckGroupResponse (
    @SerialName("checkGroupId")
    val checkGroupId: String? = null,
    @SerialName("checkList")
    val checkList: List<CheckResponse>? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("completion")
    val completion: Float? = null,
    @SerialName("image")
    val image: String? = null
)