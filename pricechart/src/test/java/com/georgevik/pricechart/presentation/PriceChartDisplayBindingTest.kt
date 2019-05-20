package com.georgevik.pricechart.presentation

import com.github.mikephil.charting.data.LineData
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class PriceChartDisplayBindingTest {

    //region ATTRIBUTES
    @InjectMockKs
    lateinit var displayBinding: PriceChartDisplayBinding
    //endregion ATTRIBUTES

    //region SETUP
    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }
    //endregion SETUP

    //region TEST
    @Test
    fun testThatLoadingIsFalse_ByDefault() {
        Assert.assertFalse(displayBinding.isLoading.get())
    }

    @Test
    fun testThatCurrentPriceLabelIsRoundedFloor_When_UpdatingDisplayBinding_And_SecondDecimalIsLowerThanFive() {
        val display = PriceChartDisplay(1.33333, Date(), mockk())

        displayBinding.update(display)

        Assert.assertEquals("1.33", displayBinding.currentPrice.get())
    }

    @Test
    fun testThatCurrentPriceLabelIsRoundedUp_When_UpdatingDisplayBinding_And_SecondDecimalIsGreaterThanFive() {
        val display = PriceChartDisplay(1.66666, Date(), mockk())

        displayBinding.update(display)

        Assert.assertEquals("1.67", displayBinding.currentPrice.get())
    }

    @Test
    fun testThatDateLabelContainsTheFullFormatDatetime_UpdatingDisplayBinding() {
        val date = Date(1254550001)
        val display = PriceChartDisplay(1.66666, date, mockk())

        displayBinding.update(display)

        Assert.assertEquals("15 January 1970, 13:29", displayBinding.date.get())
    }

    @Test
    fun testThatLineDataIsTheSameThatDisplay_When_UpdatingDisplayBinding() {
        val lineData = mockk<LineData>()
        val display = PriceChartDisplay(1.66666, Date(), lineData)

        displayBinding.update(display)

        Assert.assertSame(lineData, displayBinding.lineData.get())
    }
    //endregion TEST


}