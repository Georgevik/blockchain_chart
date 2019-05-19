package com.georgevik.pricechart.domain.repositories

import com.georgevik.pricechart.domain.ChartDuration
import com.georgevik.pricechart.domain.MarketPriceChart
import io.reactivex.Single

interface MarketPriceRepository {
    fun requestMarketPrice(duration: ChartDuration): Single<MarketPriceChart>
}