package com.georgevik.pricechart.presentation

import androidx.arch.core.util.Function
import com.georgevik.pricechart.domain.MarketPriceChart
import com.georgevik.pricechart.presentation.factory.LineDataFactory
import com.github.mikephil.charting.data.Entry
import javax.inject.Inject

class PriceChartDisplayMapper @Inject constructor(
    private val lineDataFactory: LineDataFactory
) : Function<MarketPriceChart, PriceChartDisplay> {

    //region MAPPER
    override fun apply(input: MarketPriceChart): PriceChartDisplay {
        require(input.values.isNotEmpty()) { "Values must not be empty" }

        val lineData = lineDataFactory.create(
            input.values.map { Entry(it.date.time.toFloat(), it.value.toFloat()) },
            input.name
        )

        return PriceChartDisplay(
            input.values.last().value,
            input.values.last().date,
            lineData
        )
    }
    //endregion MAPPER

}