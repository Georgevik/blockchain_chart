package com.georgevik.base.presentation

import androidx.lifecycle.*
import com.georgevik.base.exception.Failure
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    //region ATTRIBUTES
    protected val compositeDisposable = CompositeDisposable()
    private val failureMutableLiveData: MutableLiveData<Failure> = MutableLiveData()
    //endregion ATTRIBUTES

    //region LIFECYCLE
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate() = Unit

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
    //endregion LIFECYCLE

    //region FAILURE HANDLER
    val failureLiveData: LiveData<Failure> = failureMutableLiveData

    protected fun handleError(failure: Failure?) {
        failureMutableLiveData.postValue(failure)
    }

    protected fun clearError() = handleError(null)
    //endregion FAILURE HANDLER


}