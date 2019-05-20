package com.georgevik.pricechart.presentation

import com.georgevik.base.exception.Failure
import com.georgevik.base.presentation.BaseViewModel
import com.georgevik.pricechart.domain.ChartDuration
import com.georgevik.pricechart.domain.useCases.RequestMarketPriceUseCase
import javax.inject.Inject
import javax.inject.Provider

class PriceChartViewModel @Inject constructor(
    private val marketPriceUseCase: RequestMarketPriceUseCase,
    private val chartCardModelMapper: PriceChartDisplayMapper,
    priceChartDisplayBindingProvider: Provider<PriceChartDisplayBinding>
) : BaseViewModel() {

    //region ATTRIBUTES
    val display: PriceChartDisplayBinding = priceChartDisplayBindingProvider.get()
    //endregion ATTRIBUTES

    //region LIFECYCLE
    override fun onCreate() {
        super.onCreate()
        requestMarketPrices(ChartDuration.FIVE_WEEKS)
    }
    //endregion LIFECYCLE

    //region REQUEST
    private fun requestMarketPrices(duration: ChartDuration) {
        compositeDisposable.add(
            marketPriceUseCase
                .execute(duration)
                .doOnSubscribe { display.loading(true) }
                .doFinally { display.loading(false) }
                .map { chartCardModelMapper.apply(it) }
                .doOnSuccess { clearError() }
                .subscribe({ display.update(it) }, { handleError(Failure.ServerError) })
        )
    }
    //endregion REQUEST
}