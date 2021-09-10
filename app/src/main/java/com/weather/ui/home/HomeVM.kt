package com.weather.ui.home

import com.weather.base.DisposeApp
import com.weather.deps.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(scheduler: SchedulerProvider) : DisposeApp() {

}