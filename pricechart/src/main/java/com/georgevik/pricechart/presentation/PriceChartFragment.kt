package com.georgevik.pricechart.presentation

import android.os.Bundle
import com.georgevik.base.extension.createVM
import com.georgevik.base.presentation.BaseFragmentInjector
import com.georgevik.pricechart.PriceChartComponent
import com.georgevik.pricechart.R
import javax.inject.Inject

class PriceChartFragment @Inject constructor() : BaseFragmentInjector<PriceChartComponent.Provider>() {

    @Inject
    lateinit var viewModel: PriceChartViewModel

    override fun onInject(provider: PriceChartComponent.Provider) = provider.getComponent().inject(this)

    override fun getLayoutId(): Int = R.layout.fragment_price_chart

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = createVM(viewModelFactory)
    }
}