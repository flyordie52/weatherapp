package com.weatherapp.domain.model

data class Hours(
    val datetime: String,
    val tempmax: Double?,
    val tempmin: Double?,
    val temp: Double?,
    val feelslikemax: Double?,
    val feelslikemin: Double?,
    val feelslike: Double?,
    val humidity: Double?,
    val precip: Double?,
    val preciptype: List<PrecipationType>?,
    val windspeed: Double?,
    val pressure: Double?,
    val visibility: Double,
    val uvindex: Int?,
    val sunrise: String,
    val sunset: String,
    val conditions: String,
    val description: String,
    val icon: String,
    val source: String
)