package com.evoionosp.qapital.common

data class ApiResponse<T>(
    val data: T,
    val responseTimeMs: Long
)