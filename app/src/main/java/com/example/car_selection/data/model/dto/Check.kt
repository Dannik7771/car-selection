package com.example.car_selection.data.model.dto

data class Check (
    val stepList: ArrayList<Step>,
    val title: String,
    val status: String,
    val description: String,
    val description_warning: String,
    val description_alert: String,
    val category: String,
    val images: ArrayList<String>
)