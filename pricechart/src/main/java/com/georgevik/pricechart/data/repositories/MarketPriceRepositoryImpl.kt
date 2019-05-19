package com.georgevik.pricechart.data.repositories

import com.georgevik.pricechart.data.BlockchainChartApi
import com.georgevik.pricechart.data.mappers.ChartDurationMapper
import com.georgevik.pricechart.data.mappers.MarketPriceChartMapper
import com.georgevik.pricechart.domain.ChartDuration
import com.georgevik.pricechart.domain.MarketPriceChart
import com.georgevik.pricechart.domain.repositories.MarketPriceRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MarketPriceRepositoryImpl @Inject constructor(
    private val blockchainChartApi: BlockchainChartApi,
    private val chartDurationMapper: ChartDurationMapper,
    private val marketPriceChartMapper: MarketPriceChartMapper
) : MarketPriceRepository {

    override fun requestMarketPrice(duration: ChartDuration): Single<MarketPriceChart> {
        val timespan = chartDurationMapper.apply(duration)

        return blockchainChartApi
            .getCreditDrafts(timespan)
            .map { marketPriceChartMapper.apply(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
    }
}