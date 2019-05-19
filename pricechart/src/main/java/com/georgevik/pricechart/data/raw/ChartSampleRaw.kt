package com.georgevik.pricechart.data.raw

import com.google.gson.annotations.SerializedName

data class ChartSampleRaw constructor(
    @SerializedName("x") val x: Long?,
    @SerializedName("y") val y: Double?
)