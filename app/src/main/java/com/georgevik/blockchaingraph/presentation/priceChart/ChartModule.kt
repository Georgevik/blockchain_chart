package com.georgevik.blockchaingraph.presentation.priceChart

import androidx.lifecycle.ViewModelProvider
import com.georgevik.base.presentation.ViewModelUtil
import com.georgevik.blockchaingraph.presentation.ActivityModule
import com.georgevik.pricechart.data.repositories.MarketPriceRepositoryImpl
import com.georgevik.pricechart.domain.repositories.MarketPriceRepository
import com.georgevik.pricechart.presentation.PriceChartViewModel
import dagger.Module
import dagger.Provides

@Module(includes = [ActivityModule::class])
class ChartModule {

    @Provides
    fun provideViewModelProviderFactory(
        viewModelUtil: ViewModelUtil,
        viewModel: PriceChartViewModel
    ): ViewModelProvider.Factory {
        return viewModelUtil.createFor(viewModel)
    }

    @Provides
    fun provideMarketPriceRepository(implementation: MarketPriceRepositoryImpl): MarketPriceRepository = implementation

}