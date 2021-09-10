package com.weather.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class DisposeApp: ViewModel() {

    protected var dispose: Disposable = CompositeDisposable()

    fun dispose() {
        if (!dispose.isDisposed) dispose.dispose()
    }
}