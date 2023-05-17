package com.ostdan.car_selection.domain.model

data class CheckDTO(
    val checkId: String,
    val title: String,
    val status: String?,
    val description: String,
    val descriptionWarning: String,
    val descriptionAlert: String,
    val category: String,
    val image: String,
    val steps: List<StepDTO>
) {
    data class StepDTO(
        val stepId: String,
        val title: String,
        val description: String,
        val descriptionWarning: String,
        val stepImage: String,
        val question: QuestionDTO,
    ) {
        data class QuestionDTO(
            val questionId: String,
            val text: String,
            val answers: List<AnswerDTO>,
            val selectedAnswerId: String? = null
        ) {
            data class AnswerDTO (
                val answerId: String,
                val text: String,
            )
        }
    }
}