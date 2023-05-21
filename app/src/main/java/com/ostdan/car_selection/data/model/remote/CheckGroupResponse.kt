package com.ostdan.car_selection.data.model.remote

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CheckGroupResponse(
    @SerializedName("checkGroupId") val checkGroupId: String,
    @SerializedName("name") val name: String,
    @SerializedName("completion") val completion: Float,
    @SerializedName("image") val image: String,
    @SerializedName("categories") val categories: List<Category>,
) {
    @Serializable
    data class Category(
        @SerializedName("category") val category: String,
        @SerializedName("checks") val checks: List<Check>
    ) {
        @Serializable
        data class Check(
            @SerializedName("checkId") val checkId: String,
            @SerializedName("title") val title: String,
            @SerializedName("status") val status: String,
            @SerializedName("image") val image: String
        )
    }
}