package com.georgevik.pricechart.presentation

import com.georgevik.base.presentation.BaseFragmentInjector
import com.georgevik.pricechart.PriceChartComponent
import com.georgevik.pricechart.R
import javax.inject.Inject

class PriceChartFragment @Inject constructor() : BaseFragmentInjector<PriceChartComponent.Provider>() {

    override fun onInject(provider: PriceChartComponent.Provider) = provider.getComponent().inject(this)

    override fun getLayoutId(): Int = R.layout.fragment_price_chart

}