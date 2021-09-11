package com.weather.api

import com.weather.model.response.DetailWeatherResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET(value = "ata/2.5/weather?q={cityName}&appid={apiKey}")
    fun fetchDetail(
        @Path(value = "cityName") cityName: String,
        @Path(value = "apiKey") apiKey: String,
    ): Observable<DetailWeatherResponse>
}