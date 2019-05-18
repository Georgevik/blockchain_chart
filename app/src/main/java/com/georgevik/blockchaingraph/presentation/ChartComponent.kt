package com.georgevik.blockchaingraph.presentation

import com.georgevik.base.injection.scopes.ActivityScope
import com.georgevik.blockchaingraph.injection.ActivityModule
import com.georgevik.pricechart.PriceChartComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ChartComponent : PriceChartComponent.Provider {

    fun inject(activity: ChartActivity)

}