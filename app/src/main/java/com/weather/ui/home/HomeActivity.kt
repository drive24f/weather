package com.weather.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.weather.base.BaseActivity
import com.weather.databinding.ActivitySplashBinding
import com.weather.ui.splash.SplashVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivitySplashBinding>() {

    private val viewModel: SplashVM by viewModels()

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    override fun getActivityBinding(inflater: LayoutInflater) = ActivitySplashBinding
        .inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}