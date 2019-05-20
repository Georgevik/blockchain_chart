package com.georgevik.pricechart.presentation

import android.os.Bundle
import android.view.View
import com.georgevik.base.exception.Failure
import com.georgevik.base.extension.createVM
import com.georgevik.base.extension.failure
import com.georgevik.base.extension.formatDayMonthDate
import com.georgevik.base.presentation.BaseFragmentInjector
import com.georgevik.pricechart.PriceChartComponent
import com.georgevik.pricechart.R
import com.georgevik.pricechart.databinding.FragmentPriceChartBinding
import com.github.mikephil.charting.formatter.ValueFormatter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.price_chart_card_view.*
import java.util.*
import javax.inject.Inject


class PriceChartFragment @Inject constructor() : BaseFragmentInjector<PriceChartComponent.Provider>() {

    //region ATTRIBUTES
    lateinit var viewModel: PriceChartViewModel
    //endregion ATTRIBUTES

    //region BASE FRAGMENT
    override fun onInject(provider: PriceChartComponent.Provider) = provider.getComponent().inject(this)

    override fun getLayoutId(): Int = R.layout.fragment_price_chart
    //endregion BASE FRAGMENT

    //region LIFECYCLE
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel(view)
        setupChart()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        onFailure(null)
    }

    private fun initViewModel(view: View) {
        viewModel = createVM(viewModelFactory) {
            failure(failureLiveData, ::onFailure)
            lifecycle.addObserver(this)
        }
        FragmentPriceChartBinding.bind(view).display = viewModel.display
    }
    //endregion LIFECYCLE

    //region CHART
    private fun setupChart() {
        line_chart.description = null
        line_chart.legend.isEnabled = false
        line_chart.xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return Date(value.toLong()).formatDayMonthDate()
            }
        }
        line_chart.axisRight.isEnabled = false
    }
    //endregion CHART

    //region ERROR
    private fun onFailure(onFailure: Failure?) {
        if (onFailure == null) {
            return;
        }

        this.view?.let {
            Snackbar.make(it, "Oops! We got an error".plus(onFailure.toString()), Snackbar.LENGTH_LONG).show()
        }
    }
    //endregion ERROR
}