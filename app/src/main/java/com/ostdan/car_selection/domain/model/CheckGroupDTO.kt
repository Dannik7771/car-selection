package com.ostdan.car_selection.domain.model

data class CheckGroupDTO(
    val checkGroupId: String,
    val name: String,
    val completion: Float,
    val image: String,
    val categories: List<CategoryDTO>
) {
    data class CategoryDTO(
        val category: String,
        val checks: List<CheckDTO>
    ) {
        data class CheckDTO(
            val checkId: String,
            val title: String,
            val status: String,
            val image: String
        )
    }
}