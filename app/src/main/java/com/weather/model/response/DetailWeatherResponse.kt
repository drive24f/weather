package com.weather.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DetailWeatherResponse(
    @SerializedName(value = "")
    @Expose
    var data: String? = null
)