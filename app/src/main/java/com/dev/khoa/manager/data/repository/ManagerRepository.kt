package com.dev.khoa.manager.data.repository

import com.dev.khoa.manager.data.source.remote.ApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ManagerRepository @Inject constructor(private val service: ApiService) {

    suspend fun getData() = flow {
        emit(service.getData())
    }
}