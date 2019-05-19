package com.georgevik.base.presentation

import android.os.Bundle

abstract class BaseActivityInjector<T> : BaseActivity() {

    private var component: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject(getComponent())
    }

    fun getComponent(): T = component ?: createComponent()

    protected abstract fun inject(component: T)

    protected abstract fun createComponent(): T
}