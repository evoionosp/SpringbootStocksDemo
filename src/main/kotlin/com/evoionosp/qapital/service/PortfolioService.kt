package com.evoionosp.qapital.service
import com.evoionosp.qapital.common.ApiException
import com.evoionosp.qapital.common.Constants.DECIMAL_PLACES
import com.evoionosp.qapital.common.Constants.DEFAULT_STOCK_PRICE
import com.evoionosp.qapital.model.SplitOrderRequest
import com.evoionosp.qapital.model.SplitOrderResponse
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode

@Service
class PortfolioService() {


    fun splitStockOrder(request: SplitOrderRequest): SplitOrderResponse {

        validateRequest(request)

        val breakdown = request.portfolio.map { (ticker, percentage) ->
            val orderType = request.orderType
            val stockPrice:BigDecimal = request.marketPrices[ticker] ?: DEFAULT_STOCK_PRICE.toBigDecimal()
            val allocatedAmount = request.amount.multiply(percentage).setScale(2, RoundingMode.HALF_UP)
            val stockQuantity = allocatedAmount.divide(stockPrice, DECIMAL_PLACES, RoundingMode.DOWN)
            val finalAmount = stockQuantity.multiply(stockPrice).setScale(2, RoundingMode.HALF_UP)


            SplitOrderResponse.Order(
                orderType = orderType,
                ticker = ticker,
                amount = finalAmount,
                quantity = stockQuantity
            )
        }

        return SplitOrderResponse(breakdown)
    }

    private fun validateRequest(request: SplitOrderRequest) {

        if (request.amount <= BigDecimal.ZERO) {
            throw ApiException(HttpStatus.BAD_REQUEST, "Amount less than zero")
        }
        if (request.portfolio.isEmpty()) {
            throw ApiException(HttpStatus.BAD_REQUEST, "Empty portfolio")
        }


        val portfolioTotal = request.portfolio.values.sumOf { it }
        println("portfolio total: $portfolioTotal")

        if (portfolioTotal > 1.00.toBigDecimal() || portfolioTotal < 0.99.toBigDecimal()) {
            throw ApiException(HttpStatus.BAD_REQUEST, "Portfolio fractions does not add up to 1")
        }
        //added some tolerance for total sum of fractions < 1 like 0.9999
    }
}
