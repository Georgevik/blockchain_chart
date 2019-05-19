package com.georgevik.pricechart.domain.useCases

import com.georgevik.base.domain.useCases.RequestUseCase
import com.georgevik.pricechart.domain.ChartDuration
import com.georgevik.pricechart.domain.MarketPriceChart
import com.georgevik.pricechart.domain.repositories.MarketPriceRepository
import javax.inject.Inject


class RequestMarketPriceUseCase @Inject constructor(
    private val repository: MarketPriceRepository
) : RequestUseCase<MarketPriceChart, ChartDuration> {

    override fun execute(input: ChartDuration) = repository.requestMarketPrice(input)

}