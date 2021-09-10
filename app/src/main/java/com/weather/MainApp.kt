package com.weather

import android.os.StrictMode
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import io.reactivex.exceptions.UndeliverableException
import io.reactivex.plugins.RxJavaPlugins
import java.io.IOException
import java.net.SocketException

@HiltAndroidApp
class MainApp : MultiDexApplication() {

    private var mainApp: MainApp = this@MainApp

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(mainApp)
        strictMode()
        catchUnDeliveryError()
    }

    private fun strictMode() {
        val policy: StrictMode.ThreadPolicy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
    }

    private fun catchUnDeliveryError() {
        RxJavaPlugins.setErrorHandler { e ->
            if (e is UndeliverableException) {
                // fine, UndeliverableException
                return@setErrorHandler
            }
            if (e is IOException || e is SocketException) {
                // fine, irrelevant network problem or API that throws on cancellation
                return@setErrorHandler
            }
            if (e is InterruptedException) {
                // fine, some blocking code was interrupted by a dispose call
                return@setErrorHandler
            }
            if (e is NullPointerException || e is IllegalArgumentException) {
                // that's likely a bug in the application
                return@setErrorHandler
            }
            if (e is IllegalStateException) {
                // that's a bug in RxJava or in a custom operator
                return@setErrorHandler
            }
        }
    }
}