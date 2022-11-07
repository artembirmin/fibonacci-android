/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

package com.incetro.fibonacci.app

import android.app.Application
import com.incetro.fibonacci.BuildConfig
import com.incetro.fibonacci.common.di.componentmanager.ComponentsManager
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        inject()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun inject() {
        ComponentsManager.init(this)
        ComponentsManager.getInstance().applicationComponent.inject(this)
    }
}