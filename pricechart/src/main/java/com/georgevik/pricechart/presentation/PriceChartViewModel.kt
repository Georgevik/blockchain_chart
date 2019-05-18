package com.georgevik.pricechart.presentation

import androidx.lifecycle.ViewModel
import com.georgevik.base.providers.StringResources
import javax.inject.Inject

class PriceChartViewModel @Inject constructor(
    private val stringRes: StringResources
) : ViewModel()