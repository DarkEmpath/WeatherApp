package com.example.weather.adapters

data class WeatherInformations(
    val city : String,
    val time : String,
    val condition : String,
    val currentTemp : String,
    val maxTem : String,
    val minTem : String,
    val imageUrl : String,
    val hours : String
)