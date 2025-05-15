package com.evoionosp.qapital.common

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiExceptionHandler {

    @ExceptionHandler(ApiException::class)
    fun handleApiException(exception: ApiException): ResponseEntity<Map<String, String>> {
        val errorResponse = mapOf("error" to exception.message)
        return ResponseEntity(errorResponse, exception.status)
    }
}


class ApiException(
    val status: HttpStatus,
    override val message: String
) : RuntimeException(message)
