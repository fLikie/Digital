package com.example.digital.connections

import com.example.digital.model.entity.AuthClass
import com.example.digital.model.entity.ServerResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DigitalApi {

    @POST("login")
    fun login(
        @Body authClass: AuthClass
    ): Single<ServerResponse>
}