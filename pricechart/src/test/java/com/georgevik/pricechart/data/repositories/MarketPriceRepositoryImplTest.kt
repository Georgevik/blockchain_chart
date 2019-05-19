package com.georgevik.pricechart.data.repositories

import com.georgevik.pricechart.data.BlockchainChartApi
import com.georgevik.pricechart.data.mappers.ChartDurationMapper
import com.georgevik.pricechart.data.mappers.MarketPriceChartMapper
import com.georgevik.pricechart.data.raw.MarketPriceChartRaw
import com.georgevik.pricechart.domain.ChartDuration
import com.georgevik.pricechart.domain.MarketPriceChart
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class MarketPriceRepositoryImplTest {

    //region ATTRIBUTES
    @MockK
    lateinit var blockchainChartApi: BlockchainChartApi

    @MockK
    lateinit var chartDurationMapper: ChartDurationMapper

    @MockK
    lateinit var marketPriceChartMapper: MarketPriceChartMapper

    @InjectMockKs
    lateinit var repository: MarketPriceRepositoryImpl
    //endregion ATTRIBUTES

    //region SETUP
    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        every { chartDurationMapper.apply(any()) } returns ""
        every { marketPriceChartMapper.apply(any()) } returns mockk()
        mockBlockChain()
    }
    //endregion SETUP

    //region TEST
    @Test
    fun testThatTimespanIsBuildWithTheChartDuration() {
        val timestamp = "myTimeStamp"
        every { chartDurationMapper.apply(ChartDuration.FIVE_WEEKS) } returns timestamp

        repository.requestMarketPrice(ChartDuration.FIVE_WEEKS).test()

        verify { blockchainChartApi.getCreditDrafts(timestamp) }
    }

    @Test
    fun testThatExpectedMarketPriceChartIsRetrieved_When_BlockChainApiEmitsAnEvent() {
        val rawItem = mockk<MarketPriceChartRaw>()
        val expectedConversion = mockk<MarketPriceChart>()
        every { marketPriceChartMapper.apply(rawItem) } returns expectedConversion
        mockBlockChain(rawItem)

        val test = repository.requestMarketPrice(ChartDuration.FIVE_WEEKS).test()

        test.await()
        test.assertValue(expectedConversion)
    }
    //endregion TEST

    //region MOCK
    private fun mockBlockChain(item: MarketPriceChartRaw = mockk()) {
        every { blockchainChartApi.getCreditDrafts(any()) } returns Single.create { it.onSuccess(item) }
    }
    //endregion MOCK
}