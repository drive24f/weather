package com.weather.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.weather.base.BaseActivity
import com.weather.common.ResourceStatus
import com.weather.databinding.ActivityHomeBinding
import com.weather.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    private val viewModel: HomeVM by viewModels()

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    override fun getActivityBinding(inflater: LayoutInflater) = ActivityHomeBinding
        .inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initButton()
        observeData()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.dispose()
    }

    private fun initButton() {
        bind.btnCurrentLocation.setOnClickListener {

        }

        bind.btnWarszawa.setOnClickListener {
            goToDetail(cityName = "Warszawa")
        }

        bind.btnWroclaw.setOnClickListener {
            goToDetail(cityName = "Wroclaw")
        }

        bind.btnLodz.setOnClickListener {
            goToDetail(cityName = "Lodz")
        }
    }

    private fun goToDetail(cityName: String) {
        DetailActivity.start(context = this, cityName = cityName)
    }

    private fun observeData() {
        observe(viewModel.currentResult) { result ->
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