package com.georgevik.pricechart.data.mappers

import com.georgevik.pricechart.data.raw.ChartSampleRaw
import com.georgevik.pricechart.data.raw.MarketPriceChartRaw
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MarketPriceChartMapperTest {

    //region ATTRIBUTES
    @MockK
    lateinit var chartSampleMapper: ChartSampleMapper

    @InjectMockKs
    lateinit var mapper: MarketPriceChartMapper
    //endregion ATTRIBUTES

    //region SETUP
    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        every { chartSampleMapper.apply(any()) } returns mockk()
    }
    //endregion SETUP

    //region TEST ASSERTS
    @Test
    fun testThatExceptionIsThrown_When_NameParamIsNull() {
        val raw = mockChartSampleRaw(
            name = null, period = "day", description = "description", values = emptyList()
        )

        try {
            mapper.apply(raw)
            Assert.fail()
        } catch (e: Exception) {
            Assert.assertEquals("name must not be null. raw", e.message)
        }
    }

    @Test
    fun testThatExceptionIsThrown_When_PeriodParamIsNull() {
        val raw = mockChartSampleRaw(
            name = "name", period = null, description = "description", values = emptyList()
        )

        try {
            mapper.apply(raw)
            Assert.fail()
        } catch (e: Exception) {
            Assert.assertEquals("period must not be null. raw", e.message)
        }
    }

    @Test
    fun testThatExceptionIsThrown_When_DescriptionParamIsNull() {
        val raw = mockChartSampleRaw(
            name = "name", period = "period", description = null, values = emptyList()
        )

        try {
            mapper.apply(raw)
            Assert.fail()
        } catch (e: Exception) {
            Assert.assertEquals("description must not be null. raw", e.message)
        }
    }

    @Test
    fun testThatExceptionIsThrown_When_ValuesParamIsNull() {
        val raw = mockChartSampleRaw(
            name = "name", period = "period", description = "description", values = null
        )

        try {
            mapper.apply(raw)
            Assert.fail()
        } catch (e: Exception) {
            Assert.assertEquals("values must not be null. raw", e.message)
        }
    }
    //endregion TEST ASSERTS

    //region TEST
    @Test
    fun testThatChartNameIsTheSameThanNameParam() {
        val raw = mockChartSampleRaw(
            name = "name", period = "day", description = "description", values = emptyList()
        )

        val chartSample = mapper.apply(raw)

        Assert.assertEquals("name", chartSample.name)
    }

    @Test
    fun testThatChartPeriodIsTheSameThanPeriodParam() {
        val raw = mockChartSampleRaw(
            name = "name", period = "day", description = "description", values = emptyList()
        )

        val chartSample = mapper.apply(raw)

        Assert.assertEquals("day", chartSample.period)
    }

    @Test
    fun testThatChartDescriptionIsTheSameThanDescriptionParam() {
        val raw = mockChartSampleRaw(
            name = "name", period = "day", description = "description", values = emptyList()
        )

        val chartSample = mapper.apply(raw)

        Assert.assertEquals("description", chartSample.description)
    }

    @Test
    fun testThatChartValuesSizeIsTheSameThanValueSizeParam() {
        val raw = mockChartSampleRaw(
            name = "name",
            period = "day",
            description = "description",
            values = listOf(mockk(), mockk(), mockk(), mockk())
        )

        val chartSample = mapper.apply(raw)

        Assert.assertEquals(4, chartSample.values.size)
    }
    //endregion TEST

    //region MOCKS
    private fun mockChartSampleRaw(
        name: String?,
        period: String?,
        description: String?,
        values: List<ChartSampleRaw>?,
        toString: String = "raw"
    ) = mockk<MarketPriceChartRaw>().apply {
        every { this@apply.name } returns name
        every { this@apply.period } returns period
        every { this@apply.description } returns description
        every { this@apply.values } returns values
        every { this@apply.toString() } returns toString
    }
    //endregion MOCKS


}