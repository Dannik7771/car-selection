package com.ostdan.car_selection.data.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
class CheckGroupResponse (
    @SerialName("check_list")
    val checkList: ArrayList<CheckResponse>? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("completion")
    val completion: Float? = null,
    @SerialName("image")
    val image: String? = null
)