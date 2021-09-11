package com.weather.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.weather.base.BaseActivity
import com.weather.common.ResourceStatus
import com.weather.databinding.ActivitySplashBinding
import com.weather.model.request.DetailWeatherRequest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivitySplashBinding>() {

    private val viewModel: DetailVM by viewModels()

    companion object {
        fun start(context: Context, cityName: String) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("cityName", cityName)
            context.startActivity(intent)
        }
    }

    override fun getActivityBinding(inflater: LayoutInflater) = ActivitySplashBinding
        .inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initButton()
        observeData()

        if (intent.extras?.getString("cityName").orEmpty().isNotEmpty()) {
            viewModel.fetchDetail(
                DetailWeatherRequest(cityName = intent.extras?.getString("cityName"))
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.dispose()
    }

    private fun initButton() {

    }

    private fun observeData() {
        observe(viewModel.detailResult) { result ->
            when (result?.status) {
                ResourceStatus.LOADING -> {

                }
                ResourceStatus.SUCCESS -> {

                }
                ResourceStatus.ERROR -> {

                }
            }
        }
    }
}