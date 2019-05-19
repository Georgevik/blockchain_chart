package com.georgevik.blockchaingraph.presentation.priceChart

import androidx.lifecycle.ViewModelProvider
import com.georgevik.base.presentation.ViewModelUtil
import com.georgevik.blockchaingraph.presentation.ActivityModule
import com.georgevik.pricechart.data.BlockchainChartApi
import com.georgevik.pricechart.data.raw.MarketPriceChartRaw
import com.georgevik.pricechart.data.repositories.MarketPriceRepositoryImpl
import com.georgevik.pricechart.domain.repositories.MarketPriceRepository
import com.georgevik.pricechart.presentation.PriceChartViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.Single

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
    fun providerMarketPriceRepository(impl: MarketPriceRepositoryImpl): MarketPriceRepository {
        return impl
    }

    @Provides
    fun providerMarketPriceRelllpository(): BlockchainChartApi {
        return object : BlockchainChartApi {
            override fun getCreditDrafts(timeSpan: String): Single<MarketPriceChartRaw> {
                return Single.create {
                    it.onSuccess(
                        MarketPriceChartRaw(
                            null, null, null,
                            null, null, null
                        )
                    )
                }
            }

        }
    }
}