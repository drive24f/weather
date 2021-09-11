package com.weather.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName(value = "")
    @Expose
    var data: String? = null
)