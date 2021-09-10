package com.weather.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName(value = "throwable")
    @Expose
    var error: Throwable? = null
)