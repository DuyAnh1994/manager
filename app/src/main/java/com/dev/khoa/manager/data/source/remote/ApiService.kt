package com.dev.khoa.manager.data.source.remote

import com.dev.khoa.manager.data.model.Manager
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/modulotest/data.json")
    suspend fun getData(): Manager
}