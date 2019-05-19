package com.georgevik.pricechart.domain.useCases

import com.georgevik.pricechart.domain.ChartDuration
import com.georgevik.pricechart.domain.MarketPriceChart
import com.georgevik.pricechart.domain.repositories.MarketPriceRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RequestMarketPriceUseCaseTest {
    //region ATTRIBUTES
    @MockK
    lateinit var repository: MarketPriceRepository

    @InjectMockKs
    lateinit var useCase: RequestMarketPriceUseCase
    //endregion ATTRIBUTES

    //region SETUP
    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }
    //endregion SETUP

    //region TEST
    @Test
    fun testThatObservableComesFromRepository() {
        val expectedSingle = mockk<Single<MarketPriceChart>>()
        val duration = ChartDuration.FIVE_WEEKS
        every { repository.requestMarketPrice(duration) } returns expectedSingle

        val execute = useCase.execute(ChartDuration.FIVE_WEEKS)

        Assert.assertSame(expectedSingle, execute)
    }
    //endregion TEST
}