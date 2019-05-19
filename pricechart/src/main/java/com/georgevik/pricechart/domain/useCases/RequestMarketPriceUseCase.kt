package com.georgevik.pricechart.domain.useCases

import com.georgevik.base.domain.useCases.RequestUseCase
import com.georgevik.pricechart.domain.MarketPriceChart
import com.georgevik.pricechart.domain.SampleInterval
import com.georgevik.pricechart.domain.repositories.MarketPriceRepository
import javax.inject.Inject


class RequestMarketPriceUseCase @Inject constructor(
    private val repository: MarketPriceRepository
) : RequestUseCase<MarketPriceChart, SampleInterval> {

    override fun execute(input: SampleInterval) = repository.requestMarketPrice(input)

}