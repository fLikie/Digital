package com.example.digital.di.providers

import de.hdodenhof.circleimageview.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Provider

class OkHttpClientProvider @Inject constructor() : Provider<OkHttpClient> {
    override fun get(): OkHttpClient = with(OkHttpClient.Builder()) {
        connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        readTimeout(TIMEOUT, TimeUnit.SECONDS)
            addNetworkInterceptor(
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            )
        build()
    }

    companion object {
        private const val TIMEOUT = 30L
    }
}