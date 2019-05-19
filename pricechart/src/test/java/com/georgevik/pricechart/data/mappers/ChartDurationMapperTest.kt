package com.georgevik.pricechart.data.mappers

import com.georgevik.pricechart.domain.ChartDuration
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ChartDurationMapperTest {

    //region ATTRIBUTES
    @InjectMockKs
    lateinit var mapper: ChartDurationMapper
    //endregion ATTRIBUTES

    //region SETUP
    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }
    //endregion SETUP

    //region TEST
    @Test
    fun testThatApplyReturns1Weeks_When_durationIsOneWeek() {
        val result = mapper.apply(ChartDuration.ONE_WEEK)

        Assert.assertEquals("1weeks", result)
    }

    @Test
    fun testThatApplyReturns2Weeks_When_durationIsTwoWeeks() {
        val result = mapper.apply(ChartDuration.TWO_WEEKS)

        Assert.assertEquals("2weeks", result)
    }

    @Test
    fun testThatApplyReturns3Weeks_When_durationIsThreeWeeks() {
        val result = mapper.apply(ChartDuration.THREE_WEEKS)

        Assert.assertEquals("3weeks", result)
    }

    @Test
    fun testThatApplyReturns5Weeks_When_durationIsFiveWeeks() {
        val result = mapper.apply(ChartDuration.FIVE_WEEKS)

        Assert.assertEquals("5weeks", result)
    }

    @Test
    fun testThatApplyReturns1Months_When_durationIsOneMonth() {
        val result = mapper.apply(ChartDuration.ONE_MONTH)

        Assert.assertEquals("1months", result)
    }

    @Test
    fun testThatApplyReturns3Months_When_durationIsThreeMonths() {
        val result = mapper.apply(ChartDuration.THREE_MONTHS)

        Assert.assertEquals("3months", result)
    }

    @Test
    fun testThatApplyReturns1Years_When_durationIsOneYear() {
        val result = mapper.apply(ChartDuration.ONE_YEAR)

        Assert.assertEquals("1years", result)
    }
    //endregion TEST
}