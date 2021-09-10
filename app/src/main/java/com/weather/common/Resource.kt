package com.weather.common

import com.weather.model.ErrorResponse

data class Resource<T> constructor(
    var status: ResourceStatus,
    var data: T? = null,
    var error: ErrorResponse? = null
)

enum class ResourceStatus { LOADING, SUCCESS, ERROR }