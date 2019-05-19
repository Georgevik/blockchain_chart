package com.georgevik.pricechart.data

import com.georgevik.pricechart.domain.MarketPriceChart
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BlockchainAPI {

    @GET("transactions-per-second?rollingAverage=8hours&format=json")
    fun getCreditDrafts(
        @Query("timespan") timeSpan: String
    ): Single<MarketPriceChart>

}