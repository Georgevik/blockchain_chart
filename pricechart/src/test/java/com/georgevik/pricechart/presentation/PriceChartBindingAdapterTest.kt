package com.georgevik.pricechart.presentation

import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.LineData
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyOrder
import org.junit.Before
import org.junit.Test

class PriceChartBindingAdapterTest {

    //region ATTRIBUTES
    @MockK
    lateinit var chart: LineChart
    //endregion ATTRIBUTES

    //region SETUP
    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }
    //endregion SETUP

    //region TEST
    @Test
    fun testThatLineChartDataIsUpdated_When_SettingLineData() {
        val lineData: LineData = mockk()

        chart.setLineData(lineData)

        verify { chart.data = lineData }
    }

    @Test
    fun testThatLineChartInvalidates_When_SettingLineData() {
        val lineData: LineData = mockk()

        chart.setLineData(lineData)

        verify { chart.invalidate() }
    }

    @Test
    fun testThatLineChartInvalidates_After_DataIsSet() {
        val lineData: LineData = mockk()

        chart.setLineData(lineData)

        verifyOrder {
            chart.data = lineData
            chart.invalidate()
        }
    }
    //endregion TEST

}