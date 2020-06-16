package com.example.digital.di.modules

import com.example.digital.connections.DigitalApi
import com.example.digital.di.ServerPath
import com.example.digital.di.providers.ApiProvider
import com.example.digital.di.providers.GsonProvider
import com.example.digital.di.providers.OkHttpClientProvider
import com.example.digital.model.AuthInteractor
import com.google.gson.Gson
import okhttp3.OkHttpClient
import toothpick.config.Module

class ServerModule(serverUrl: String) : Module() {
    init {
        bind(String::class.java).withName(ServerPath::class.java).toInstance(serverUrl)
        bind(Gson::class.java).toProvider(GsonProvider::class.java).providesSingleton()
        bind(OkHttpClient::class.java).toProvider(OkHttpClientProvider::class.java).providesSingleton()
        bind(DigitalApi::class.java).toProvider(ApiProvider::class.java).providesSingleton()

        bind(AuthInteractor::class.java)
    }
}