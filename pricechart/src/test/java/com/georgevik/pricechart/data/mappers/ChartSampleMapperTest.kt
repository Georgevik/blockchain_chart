package com.georgevik.pricechart.data.mappers

import com.georgevik.pricechart.data.raw.ChartSampleRaw
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ChartSampleMapperTest {

    //region ATTRIBUTES
    @InjectMockKs
    lateinit var mapper: ChartSampleMapper
    //endregion ATTRIBUTES

    //region SETUP
    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }
    //endregion SETUP

    //region TEST ASSERTS
    @Test
    fun testThatExceptionIsThrown_When_XParamIsNull() {
        val raw = mockChartSampleRaw(x = null, y = 1.2)

        try {
            mapper.apply(raw)
            Assert.fail()
        } catch (e: Exception) {
            Assert.assertEquals("X must not be null. raw", e.message)
        }
    }

    @Test
    fun testThatExceptionIsThrown_When_YParamIsNull() {
        val raw = mockChartSampleRaw(x = 123, y = null)

        try {
            mapper.apply(raw)
            Assert.fail()
        } catch (e: Exception) {
            Assert.assertEquals("Y must not be null. raw", e.message)
        }
    }
    //endregion TEST ASSERTS

    //region TEST
    @Test
    fun testThatChartSampleDateIsWellParsed_When_RawRetrievesSeconds() {
        val seconds = 1558260919L
        val raw = mockChartSampleRaw(x = seconds, y = 1.2)

        val chartSample = mapper.apply(raw)

        Assert.assertEquals(seconds, chartSample.date.time / 1000)
    }

    @Test
    fun testThatChartSampleValueIsTheSameThanYParam() {
        val value = 7000.0
        val raw = mockChartSampleRaw(x = 1008260019L, y = value)

        val chartSample = mapper.apply(raw)

        Assert.assertEquals(value, chartSample.value, 0.0)
    }
    //endregion TEST

    //region MOCKS
    private fun mockChartSampleRaw(x: Long?, y: Double?, toString: String = "raw") = mockk<ChartSampleRaw>()
        .apply {
            every { this@apply.x } returns x
            every { this@apply.y } returns y
            every { this@apply.toString() } returns toString
        }
    //endregion MOCKS
}