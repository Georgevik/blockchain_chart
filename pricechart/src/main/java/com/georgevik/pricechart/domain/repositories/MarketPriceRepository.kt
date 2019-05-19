package com.georgevik.pricechart.domain.repositories

import com.georgevik.pricechart.domain.MarketPriceChart
import com.georgevik.pricechart.domain.SampleInterval
import io.reactivex.Single

interface MarketPriceRepository {
    fun requestMarketPrice(interval: SampleInterval): Single<MarketPriceChart>
}