package com.ostdan.car_selection.data.model.remote

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
data class CheckSessionResponse(
    @SerializedName("checkSessionId") val checkSessionId: String,
    @SerializedName("vin") val vin: String,
    @SerializedName("govNumber") val govNumber: String,
    @SerializedName("types") val types: List<Type>
) {
    @Serializable
    data class Type(
        @SerializedName("type") val type: String,
        @SerializedName("groups") val checkGroups: List<CheckGroup>
    ) {
        @Serializable
        data class CheckGroup(
            @SerializedName("checkGroupId") val checkGroupId: String,
            @SerializedName("name") val name: String,
            @SerializedName("image") val image: String
        )
    }
}