package com.weather.ui.detail

import com.weather.base.DisposeApp
import com.weather.deps.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailVM @Inject constructor(scheduler: SchedulerProvider) : DisposeApp() {

}