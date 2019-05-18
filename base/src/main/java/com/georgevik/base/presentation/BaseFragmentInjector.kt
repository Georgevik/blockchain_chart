package com.georgevik.base.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragmentInjector<in PROVIDER> : Fragment() {
    override fun onAttach(context: Context) {
        onInject(createInjector())

        super.onAttach(context)
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    @Suppress("UNCHECKED_CAST")
    private fun createInjector(): PROVIDER {
        val injector = activity as BaseActivityInjector<*>
        return injector.getComponent() as PROVIDER
    }

    abstract fun onInject(provider: PROVIDER)

    @LayoutRes
    protected abstract fun getLayoutId(): Int
}