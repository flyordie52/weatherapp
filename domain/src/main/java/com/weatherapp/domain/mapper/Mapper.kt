package com.weatherapp.domain.mapper

import com.weatherapp.domain.model.TodayWeather
import com.weatherapp.domain.model.UpcomingWeather
import com.weatherapp.domain.model.WeatherPicture

fun UpcomingWeather.toTodayWeather() = TodayWeather(
    latitude = latitude.toString(),
    longitude = longitude.toString(),
    resolvedAddress = resolvedAddress,
    address = address,
    timezone = timezone,
    datetime = currentConditions?.datetime.orEmpty(),
    tempmax = currentConditions?.tempmax.toString(),
    tempmin = currentConditions?.tempmin.toString(),
    temp = currentConditions?.temp.toString(),
    feelslike = currentConditions?.feelslike.toString(),
    conditions = currentConditions?.conditions.orEmpty(),
    description = currentConditions?.description.orEmpty(),
    icon = WeatherPicture.values().find {
        currentConditions?.icon?.contains(it.toString()) ?: false
    } ?: WeatherPicture.NONE ,
    days = days
)