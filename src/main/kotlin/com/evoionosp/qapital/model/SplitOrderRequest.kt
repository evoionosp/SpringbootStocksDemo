package com.evoionosp.qapital.model

import java.math.BigDecimal

data class SplitOrderRequest (

    val orderType: OrderType,
    val amount: BigDecimal,
    val portfolio: Map<String, BigDecimal>,
    val marketPrices: Map<String, BigDecimal> = emptyMap() // Optional: user can provide market prices of stock
)