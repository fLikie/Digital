package com.example.digital.connections

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DigitalApi {

    @POST("search.json")
    fun registration(
        @Query("login") login: String,
        @Query("password") password: String
    ): Single<String>

    @POST("forecast.json")
    fun login(
        @Query("login") login: String,
        @Query("password") password: String
    ): Single<String>
}