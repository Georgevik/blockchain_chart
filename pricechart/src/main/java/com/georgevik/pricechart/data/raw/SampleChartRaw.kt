package com.georgevik.pricechart.data.raw

import com.google.gson.annotations.SerializedName

data class SampleChartRaw constructor(
    @SerializedName("x") val x: Long?,
    @SerializedName("y") val y: Double?
)