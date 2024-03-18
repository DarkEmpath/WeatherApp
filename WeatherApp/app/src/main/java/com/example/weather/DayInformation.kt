package com.example.weather

data class DayInformation(
    val city: String,
    val time: String,
    val condition: String,
    val imageUrl: String,
    val nowTemp: String,
    val maxTemp: String,
    val minTemp: String,
    val hours: String
)
