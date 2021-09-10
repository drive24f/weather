package com.weather.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<vb: ViewBinding>: AppCompatActivity() {

    protected lateinit var bind: vb
    abstract fun getActivityBinding(inflater: LayoutInflater): vb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = getActivityBinding(layoutInflater)
        setContentView(bind.root)
    }

    fun <T: Any, L: LiveData<T>> observe(liveData: L, body: (T?) -> Unit) {
        liveData.observe(this, Observer(body))
    }
}