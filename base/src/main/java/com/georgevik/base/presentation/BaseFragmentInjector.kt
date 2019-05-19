package com.georgevik.base.presentation

import android.content.Context

abstract class BaseFragmentInjector<in PROVIDER> : BaseFragment() {
    override fun onAttach(context: Context) {
        onInject(createInjector())

        super.onAttach(context)
    }

    @Suppress("UNCHECKED_CAST")
    private fun createInjector(): PROVIDER {
        val injector = activity as BaseActivityInjector<*>
        return injector.getComponent() as PROVIDER
    }

    abstract fun onInject(provider: PROVIDER)


}