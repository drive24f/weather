package com.weather.ui.detail

import androidx.lifecycle.MutableLiveData
import com.weather.api.ApiService
import com.weather.base.DisposeApp
import com.weather.common.Resource
import com.weather.common.loading
import com.weather.common.setError
import com.weather.common.success
import com.weather.deps.SchedulerProvider
import com.weather.model.request.DetailWeatherRequest
import com.weather.model.response.DetailWeatherResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailVM @Inject constructor(
    private val api: ApiService,
    private val scheduler: SchedulerProvider) : DisposeApp() {

    var detailResult = MutableLiveData<Resource<DetailWeatherResponse>>()

    fun fetchDetail(request: DetailWeatherRequest) {
        dispose = api.fetchDetail(request.cityName.orEmpty(), request.apiKey.orEmpty())
            .compose(scheduler.getObservable())
            .doOnSubscribe { detailResult.loading() }
            .subscribe({ m -> detailResult.success(m) }, { e ->
                detailResult.setError()
            })
    }
}