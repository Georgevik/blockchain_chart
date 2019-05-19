package com.georgevik.pricechart.data.mappers

import androidx.arch.core.util.Function
import com.georgevik.pricechart.data.raw.ChartSampleRaw
import com.georgevik.pricechart.domain.ChartSample
import java.util.*
import javax.inject.Inject
import kotlin.contracts.contract as contract1

class ChartSampleMapper @Inject constructor() : Function<ChartSampleRaw, ChartSample> {

    override fun apply(input: ChartSampleRaw): ChartSample {
        requireNotNull(input.x) { "X must not be null. ".plus(input) }
        requireNotNull(input.y) { "Y must not be null. ".plus(input) }

        return ChartSample(Date(input.x * 1000), input.y)
    }

}