package com.weather.common

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<Resource<T>>.loading() = postValue(
    Resource(ResourceStatus.LOADING)
)

fun <T> MutableLiveData<Resource<T>>.loading(data: T? = null) = postValue(
    Resource(ResourceStatus.LOADING, data)
)

fun <T> MutableLiveData<Resource<T>>.success(data: T? = null) = postValue(
    Resource(ResourceStatus.SUCCESS, data)
)

fun <T> MutableLiveData<Resource<T>>.setError(error: T? = null) = postValue(
    Resource(ResourceStatus.ERROR, error)
)
