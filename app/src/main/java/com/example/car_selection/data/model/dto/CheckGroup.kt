package com.example.car_selection.data.model.dto

data class CheckGroup (
    val checkList: ArrayList<Check>,
    val name: String,
    val type: String,
    val completion: Float,
    val image: String
)