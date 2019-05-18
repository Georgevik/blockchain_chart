package com.georgevik.base.providers

import android.content.res.Resources
import androidx.annotation.StringRes
import javax.inject.Inject

class StringResources @Inject constructor(
    private val resources: Resources
) {

    fun getString(@StringRes idString: Int) = resources.getString(idString)

}