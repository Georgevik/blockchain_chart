package com.georgevik.blockchaingraph.presentation

import android.os.Bundle
import com.georgevik.base.presentation.BaseActivityInjector
import com.georgevik.blockchaingraph.BlockchainApplication
import com.georgevik.blockchaingraph.R
import com.georgevik.blockchaingraph.injection.ActivityModule
import com.georgevik.pricechart.presentation.PriceChartFragment
import com.georgevik.pricechart.presentation.PriceChartViewModel
import javax.inject.Inject

class ChartActivity : BaseActivityInjector<ChartComponent>() {

    override fun createComponent(): ChartComponent {
        val activityModule = ActivityModule(this)
        return BlockchainApplication.get(this).getComponent().plus(activityModule)
    }

    override fun getLayoutId(): Int = R.layout.activity_price_chart

    override fun inject(component: ChartComponent) = component.inject(this)

    @Inject
    lateinit var viewModel: PriceChartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            startFragment()
        }
    }

    private fun startFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.frame, PriceChartFragment())
            .commit()
    }
}
