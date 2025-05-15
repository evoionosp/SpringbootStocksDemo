package com.evoionosp.qapital.controller

import com.evoionosp.qapital.common.ApiResponse
import com.evoionosp.qapital.model.SplitOrderRequest
import com.evoionosp.qapital.model.SplitOrderResponse
import com.evoionosp.qapital.service.PortfolioService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
@RequestMapping("/v1/portfolio")
class PortfolioController(private val portfolioService: PortfolioService) {

    @PostMapping("/split")
    fun splitOrder(@RequestBody request: SplitOrderRequest): ApiResponse<SplitOrderResponse> {
        val startTime = Instant.now()

        val response = portfolioService.splitStockOrder(request)

        val responseTimeMs = Instant.now().toEpochMilli() - startTime.toEpochMilli()

        println("ResponseTime: $responseTimeMs")

        return ApiResponse(data = response, responseTimeMs = responseTimeMs)
    }

}