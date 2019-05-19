package com.georgevik.blockchaingraph.injection

import android.app.Application
import com.georgevik.blockchaingraph.presentation.ActivityModule
import com.georgevik.blockchaingraph.presentation.priceChart.ChartComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(app: Application)

    fun plus(module: ActivityModule): ChartComponent

}
