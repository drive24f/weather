package com.weather.model.request

import com.weather.common.ConstanHelper.API_KEY

data class CurrentWeatherRequest(
    var id: String? = null,
    val apiKey: String? = API_KEY
)