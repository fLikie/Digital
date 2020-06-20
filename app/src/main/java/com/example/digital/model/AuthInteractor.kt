package com.example.digital.model

import com.example.digital.connections.DigitalApi
import com.example.digital.di.providers.SchedulersProvider
import com.example.digital.model.entity.AuthClass
import com.example.digital.model.entity.ServerResponse
import io.reactivex.Single
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val api: DigitalApi,
    private val scheduler: SchedulersProvider
) {

    fun login(login: String, password: String): Single<ServerResponse> =
        api.login(AuthClass(login, password))
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
}