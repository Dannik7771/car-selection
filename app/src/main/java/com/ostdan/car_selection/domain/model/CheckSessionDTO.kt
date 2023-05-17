package com.ostdan.car_selection.domain.model

data class CheckSessionDTO(
    val checkSessionId: String,
    val vin: String,
    val govNumber: String,
    val types: List<TypeDTO>
) {
    data class TypeDTO(
        val type: String,
        val checkGroups: List<CheckGroupDTO>
    ) {
        data class CheckGroupDTO(
            val checkGroupId: String,
            val name: String,
            val image: String
        )
    }
}