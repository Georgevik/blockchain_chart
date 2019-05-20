package com.georgevik.pricechart.presentation

import com.georgevik.pricechart.domain.ChartSample
import com.georgevik.pricechart.domain.MarketPriceChart
import com.georgevik.pricechart.presentation.factory.LineDataFactory
import com.github.mikephil.charting.data.LineData
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class PriceChartDisplayMapperTest {
    //region ATTRIBUTES
    @MockK
    lateinit var lineDataFactory: LineDataFactory

    @InjectMockKs
    lateinit var mapper: PriceChartDisplayMapper
    //endregion ATTRIBUTES

    //region SETUP
    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        every { lineDataFactory.create(any(), any()) } returns mockk()
    }
    //endregion SETUP

    //region TEST ASSERTS
    @Test
    fun testThatExceptionIsThrown_When_ValuesAreEmpty() {
        val raw = MarketPriceChart("", "", "", emptyList())

        try {
            mapper.apply(raw)
            Assert.fail()
        } catch (e: Exception) {
            Assert.assertEquals("Values must not be empty", e.message)
        }
    }
    //region TEST ASSERTS

    //region TEST
    @Test
    fun testThatCurrencyPriceIsTheLastValue() {
        val first = ChartSample(Date(), 1.2)
        val second = ChartSample(Date(), 2.4)
        val raw = MarketPriceChart("", "", "", listOf(first, second))


        val display = mapper.apply(raw)

        Assert.assertEquals(second.value, display.currencyPrice, 0.0)
    }

    @Test
    fun testThatDateIsTheSameLastItemDate() {
        val first = ChartSample(Date(1558386028000), 1.2)
        val second = ChartSample(Date(1008000028000), 2.4)
        val raw = MarketPriceChart("", "", "", listOf(first, second))

        val display = mapper.apply(raw)

        Assert.assertEquals(second.date.time, display.date.time)
    }

    @Test
    fun testThatLineDataIsRetrievedFromLineDataFactory() {
        val lineData = mockk<LineData>()
        every { lineDataFactory.create(any(), any()) } returns lineData
        val first = ChartSample(Date(1558386028000), 1.2)
        val second = ChartSample(Date(1008000028), 2.4)
        val raw = MarketPriceChart("", "", "", listOf(first, second))

        val display = mapper.apply(raw)

        Assert.assertEquals(lineData, display.lineData)
    }
    //endregion TEST
}