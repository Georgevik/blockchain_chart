package com.georgevik.pricechart.presentation

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.georgevik.base.extension.formatFullDatetime
import com.georgevik.base.extension.round
import com.github.mikephil.charting.data.LineData
import javax.inject.Inject

class PriceChartDisplayBinding @Inject constructor() {

    //region BINDING
    val currentPrice = ObservableField("")

    val date = ObservableField("")

    val isLoading = ObservableBoolean(false)

    val lineData = ObservableField<LineData>()
    //endregion BINDING

    //region UPDATE
    fun update(display: PriceChartDisplay) {
        currentPrice.set(display.currencyPrice.round(2).toString())
        date.set(display.date.formatFullDatetime())
        lineData.set(display.lineData)
    }

    fun loading(isVisible: Boolean) {
        isLoading.set(isVisible)
    }
    //endregion UPDATE
}