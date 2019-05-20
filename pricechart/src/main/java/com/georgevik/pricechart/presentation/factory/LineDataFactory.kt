package com.georgevik.pricechart.presentation.factory

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import javax.inject.Inject

class LineDataFactory @Inject constructor(
    private val lineDataSetFactory: LineDataSetFactory
) {

    //region FACTORY
    fun create(
        values: List<Entry>,
        label: String
    ) = LineData(lineDataSetFactory.create(values, label)).apply {
        setDrawValues(false)
    }
    //endregion FACTORY
}