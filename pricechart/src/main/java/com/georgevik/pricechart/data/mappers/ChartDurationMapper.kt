package com.georgevik.pricechart.data.mappers

import androidx.arch.core.util.Function
import com.georgevik.pricechart.domain.ChartDuration
import javax.inject.Inject

class ChartDurationMapper @Inject constructor() : Function<ChartDuration, String> {

    override fun apply(input: ChartDuration) = when (input) {
        ChartDuration.ONE_WEEK -> "1weeks"
        ChartDuration.TWO_WEEKS -> "2weeks"
        ChartDuration.THREE_WEEKS -> "3weeks"
        ChartDuration.FIVE_WEEKS -> "5weeks"
        ChartDuration.ONE_MONTH -> "1months"
        ChartDuration.THREE_MONTHS -> "3months"
        ChartDuration.ONE_YEAR -> "1years"
    }

}