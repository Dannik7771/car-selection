package com.ostdan.car_selection.data.mapper

import com.ostdan.car_selection.data.model.remote.CheckResponse
import com.ostdan.car_selection.domain.model.CheckDTO

class CheckMapper {
    fun map(response: CheckResponse): CheckDTO = CheckDTO(
        checkId = response.checkId,
        title = response.title,
        status = response.status,
        description = response.description,
        descriptionWarning = response.descriptionWarning,
        descriptionAlert = response.descriptionAlert,
        category = response.category,
        image = response.image,
        steps = response.steps.map { map(it) }
    )

    private fun map(step: CheckResponse.Step): CheckDTO.StepDTO = CheckDTO.StepDTO(
        stepId = step.stepId,
        title = step.title,
        description = step.description,
        descriptionWarning = step.descriptionWarning,
        stepImage = step.stepImage,
        question = map(step.question)
    )

    private fun map(question: CheckResponse.Step.Question): CheckDTO.StepDTO.QuestionDTO =
        CheckDTO.StepDTO.QuestionDTO(
            questionId = question.questionId,
            text = question.text,
            answers = question.answers.map { map(it) },
            selectedAnswerId = question.selectedAnswerId
        )

    private fun map(answer: CheckResponse.Step.Question.Answer): CheckDTO.StepDTO.QuestionDTO.AnswerDTO =
        CheckDTO.StepDTO.QuestionDTO.AnswerDTO(
            answerId = answer.answerId,
            text = answer.text
        )
}