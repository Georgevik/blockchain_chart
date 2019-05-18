package com.georgevik.base.injection

interface ComponentProvider<T> {
    fun getComponent(): T
}