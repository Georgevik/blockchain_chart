package com.georgevik.pricechart.presentation

import androidx.databinding.BindingAdapter
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.LineData


@BindingAdapter("lineData")
fun LineChart.setLineData(lineData: LineData?) {
    data = lineData
    invalidate()
}
