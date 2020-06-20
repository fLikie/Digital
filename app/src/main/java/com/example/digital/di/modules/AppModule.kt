package com.example.digital.di.modules

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.digital.di.providers.AppSchedulers
import com.example.digital.di.providers.SchedulersProvider
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import toothpick.config.Module

class AppModule(context: Context) : Module() {
    init {
        bind(Context::class.java).toInstance(context)
        bind(SchedulersProvider::class.java).toInstance(AppSchedulers())
        val cicerone = Cicerone.create()
        bind(Router::class.java).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).toInstance(cicerone.navigatorHolder)
        bind(SharedPreferences::class.java).toInstance(context.getSharedPreferences("DIGITAL_APP", MODE_PRIVATE))
    }
}