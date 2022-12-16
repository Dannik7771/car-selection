package com.ostdan.car_selection.data.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
class CheckSessionResponse (
    @SerialName("check_group_list")
    val checkGroupList: ArrayList<CheckGroupResponse>? = null,
    @SerialName("gov_number")
    val govNumber: String? = null,
    @SerialName("vin")
    val vin: String? = null,
    @SerialName("search_successful")
    val searchSuccessful: Boolean? = null
)