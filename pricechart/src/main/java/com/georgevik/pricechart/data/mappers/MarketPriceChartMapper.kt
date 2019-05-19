package com.georgevik.pricechart.data.mappers

import androidx.arch.core.util.Function
import com.georgevik.pricechart.data.raw.MarketPriceChartRaw
import com.georgevik.pricechart.domain.MarketPriceChart
import javax.inject.Inject
import kotlin.contracts.contract as contract1

class MarketPriceChartMapper @Inject constructor(
    private val chartSampleMapper: ChartSampleMapper
) : Function<MarketPriceChartRaw, MarketPriceChart> {

    override fun apply(input: MarketPriceChartRaw): MarketPriceChart {
        requireNotNull(input.name) { "name must not be null. ".plus(input) }
        requireNotNull(input.period) { "period must not be null. ".plus(input) }
        requireNotNull(input.description) { "description must not be null. ".plus(input) }
        requireNotNull(input.values) { "values must not be null. ".plus(input) }

        return MarketPriceChart(
            input.name,
            input.period,
            input.description,
            input.values.map { chartSampleMapper.apply(it) }
        )
    }

}