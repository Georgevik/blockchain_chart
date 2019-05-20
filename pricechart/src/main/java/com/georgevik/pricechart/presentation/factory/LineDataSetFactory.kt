package com.georgevik.pricechart.presentation.factory

import android.graphics.Color
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import javax.inject.Inject

class LineDataSetFactory @Inject constructor() {

    fun create(
        values: List<Entry>,
        label: String
    ) = LineDataSet(values, label).apply {
        setDrawCircles(false)
        lineWidth = 2f
        color = Color.BLUE
        mode = LineDataSet.Mode.CUBIC_BEZIER
    }

}