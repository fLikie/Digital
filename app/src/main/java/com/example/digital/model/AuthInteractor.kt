package com.example.digital.model

import com.example.digital.connections.DigitalApi
import com.example.digital.di.providers.SchedulersProvider
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val api: DigitalApi,
    private val scheduler: SchedulersProvider
) {

}