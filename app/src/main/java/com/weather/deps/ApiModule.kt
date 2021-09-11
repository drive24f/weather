package com.weather.deps

import android.content.Context
import androidx.databinding.ktx.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.weather.api.ApiService
import com.weather.common.ConstanHelper.TIMEOUT
import com.weather.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    companion object {
        private const val BEARER: String = "Bearer"
        private const val ACCEPT: String = "Accept"
        private const val APP_JSON: String = "application/json"
        private const val NO_AUTH: String = "No-Authentication: true"
        private const val CONTENT_TYPE: String = "Content-Type: application/json"

        private var TOKEN = ""
    }

    @Provides
    @Singleton
    fun provideSchedulerProvider() = SchedulerProvider(
        Schedulers.io(), AndroidSchedulers.mainThread()
    )

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
            .create()
    }

    @Singleton
    @Provides
    @Named(value = "app")
    fun provideRetrofit(@Named(value = "okhttp") okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    @Named(value = "okhttp")
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService( @Named(value = "app") retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: ApiService) = Repository(api)

}