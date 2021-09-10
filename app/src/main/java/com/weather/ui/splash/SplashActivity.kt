package com.weather.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.weather.base.BaseActivity
import com.weather.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    private val viewModel: SplashVM by viewModels()

    override fun getActivityBinding(inflater: LayoutInflater) = ActivitySplashBinding
        .inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}