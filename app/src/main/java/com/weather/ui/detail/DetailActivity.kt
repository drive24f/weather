package com.weather.ui.detail

import android.app.Activity
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
class DetailActivity : BaseActivity<ActivitySplashBinding>() {

    private val viewModel: SplashVM by viewModels()

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, DetailActivity::class.java)
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