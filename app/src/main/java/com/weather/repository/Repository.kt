package com.weather.repository

import com.weather.api.ApiService
import javax.inject.Inject

class Repository @Inject constructor(private val api: ApiService) {
}