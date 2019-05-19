package com.georgevik.pricechart.data

import com.georgevik.pricechart.data.raw.MarketPriceChartRaw
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BlockchainChartApi {

    @GET("transactions-per-second?rollingAverage=8hours&format=json")
    fun getCreditDrafts(
        @Query("timespan") timeSpan: String
    ): Single<MarketPriceChartRaw>

}