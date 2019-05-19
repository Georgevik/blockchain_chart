package com.georgevik.pricechart.data

import com.georgevik.pricechart.data.raw.MarketPriceChartRaw
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BlockchainChartApi {

    @GET("/charts/market-price")
    fun getCreditDrafts(
        @Query("timespan") timespan: String,
        @Query("rollingAverage") rollingAverage: String = "8hours",
        @Query("format") format: String = "json"
    ): Single<MarketPriceChartRaw>

}