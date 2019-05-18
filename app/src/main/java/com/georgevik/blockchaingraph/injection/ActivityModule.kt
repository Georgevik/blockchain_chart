package com.georgevik.blockchaingraph.injection

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    private val activity: AppCompatActivity
) {

    @Provides
    fun provideResources(): Resources {
        return activity.resources
    }
}
