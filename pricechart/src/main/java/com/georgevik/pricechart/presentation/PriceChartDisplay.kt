package com.georgevik.pricechart.presentation

import com.github.mikephil.charting.data.LineData
import java.util.*

data class PriceChartDisplay constructor(
    val currencyPrice: Double,
    val date: Date,
    val lineData: LineData
)