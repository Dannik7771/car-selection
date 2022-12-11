package com.example.car_selection.data.model.dto

data class Step (
    val stepImageList: ArrayList<Step>,
    val title: String,
    val description: String,
    val description_warning: String,
    val type: String,
    val result: String
)