package com.georgevik.blockchaingraph.injection

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule constructor(
    private val appContext: Context
) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return appContext
    }

}