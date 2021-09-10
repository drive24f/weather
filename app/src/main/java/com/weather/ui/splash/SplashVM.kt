package com.weather.ui.splash

import androidx.lifecycle.MutableLiveData
import com.weather.base.DisposeApp
import com.weather.deps.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class SplashVM @Inject constructor(val scheduler: SchedulerProvider) : DisposeApp() {

    var timeOutResult: MutableLiveData<Boolean> = MutableLiveData()

    fun startTimer() {
        dispose = Observable.range(0, 2)
            .flatMap { v -> Observable.just(v).delay((2 - v).toLong(), TimeUnit.SECONDS) }
            .compose(scheduler.getObservable())
            .doAfterTerminate { timeOutResult.value = true }
            .subscribe()
    }
}