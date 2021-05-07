package com.dev.khoa.manager.data.model

data class Device(
    val deviceName: String,
    val id: Int,
    val intensity: Int,
    val mode: String,
    val position: Int,
    val productType: String,
    val temperature: Int
)