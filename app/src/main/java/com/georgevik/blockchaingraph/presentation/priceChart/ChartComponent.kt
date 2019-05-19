package com.georgevik.blockchaingraph.presentation.priceChart

import com.georgevik.base.injection.scopes.ActivityScope
import com.georgevik.pricechart.PriceChartComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ChartModule::class])
interface ChartComponent : PriceChartComponent.Provider {

    fun inject(activity: ChartActivity)

}