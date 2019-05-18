package com.georgevik.pricechart

import com.georgevik.base.injection.ComponentProvider
import com.georgevik.base.injection.scopes.FragmentScope
import com.georgevik.pricechart.presentation.PriceChartFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent
interface PriceChartComponent {

    fun inject(fragment: PriceChartFragment)

    interface Provider : ComponentProvider<PriceChartComponent>
}

