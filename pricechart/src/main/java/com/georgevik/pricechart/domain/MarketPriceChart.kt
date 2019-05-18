package com.georgevik.pricechart.domain

data class MarketPriceChart constructor(
    val name: String,
    val period: String,
    val description: String,
    val values: List<ChartSample>
)