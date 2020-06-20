package com.example.digital

import android.app.Application
import com.example.digital.di.Scopes
import com.example.digital.di.modules.AppModule
import com.example.digital.di.modules.ServerModule
import de.hdodenhof.circleimageview.BuildConfig
import timber.log.Timber
import toothpick.Toothpick
import toothpick.configuration.Configuration

class DigitalApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initAppScope()
        initToothpick()
        initLogger()
    }

    private fun initAppScope() {
        Toothpick
            .openScope(Scopes.APP_SCOPE)
            .installModules(AppModule(this))

        Toothpick
            .openScope(Scopes.SERVER_SCOPE)
            .installModules(ServerModule("http://gpb.tl81.ru/"))
    }

    private fun initToothpick() {
        if (BuildConfig.DEBUG) {
            Toothpick.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes())
        } else {
            Toothpick.setConfiguration(Configuration.forProduction())
        }
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}