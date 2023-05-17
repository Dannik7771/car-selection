package com.ostdan.car_selection.data.model.remote

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CheckResponse(
    @SerializedName("checkId") val checkId: String,
    @SerializedName("title") val title: String,
    @SerializedName("status") val status: String?,
    @SerializedName("description") val description: String,
    @SerializedName("descriptionWarning") val descriptionWarning: String,
    @SerializedName("descriptionAlert") val descriptionAlert: String,
    @SerializedName("category") val category: String,
    @SerializedName("image") val image: String,
    @SerializedName("steps") val steps: List<Step>
) {
    @Serializable
    data class Step(
        @SerializedName("stepId") val stepId: String,
        @SerializedName("title") val title: String,
        @SerializedName("description") val description: String,
        @SerializedName("descriptionWarning") val descriptionWarning: String,
        @SerializedName("stepImage") val stepImage: String,
        @SerializedName("question") val question: Question,
    ) {
        @Serializable
        data class Question(
            @SerializedName("questionId") val questionId: String,
            @SerializedName("text") val text: String,
            @SerializedName("answers") val answers: List<Answer>,
            @SerializedName("selectedAnswerId") val selectedAnswerId: String? = null
        ) {
            @Serializable
            data class Answer (
                @SerializedName("answerId") val answerId: String,
                @SerializedName("text") val text: String,
            )
        }
    }
}