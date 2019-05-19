package com.georgevik.base.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ViewModelUtil @Inject constructor() {

    fun <T : ViewModel> createFor(viewModel: T): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {

            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(viewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST")
                    return viewModel as T
                }
                throw IllegalArgumentException("unexpected viewModel class $modelClass")
            }
        }
    }

}
