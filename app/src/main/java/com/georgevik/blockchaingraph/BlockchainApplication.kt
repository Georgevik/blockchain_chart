package com.georgevik.blockchaingraph

import android.app.Application
import android.content.Context
import com.georgevik.blockchaingraph.injection.AppComponent
import com.georgevik.blockchaingraph.injection.DaggerAppComponent


class BlockchainApplication : Application() {

    private var mAppComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        initAppComponent().inject(this)
    }

    fun getComponent() = mAppComponent ?: initAppComponent()

    private fun initAppComponent(): AppComponent {
        return DaggerAppComponent.create()
    }

    companion object {
        fun get(context: Context): BlockchainApplication {
            return context.applicationContext as BlockchainApplication
        }
    }

}