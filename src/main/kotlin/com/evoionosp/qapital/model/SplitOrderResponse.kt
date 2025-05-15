package com.evoionosp.qapital.model

import java.math.BigDecimal

class SplitOrderResponse(
    val orders: List<Order>
) {
    data class Order(
        val orderType: OrderType,
        val ticker: String,
        val amount: BigDecimal,
        val quantity: BigDecimal
    )
}