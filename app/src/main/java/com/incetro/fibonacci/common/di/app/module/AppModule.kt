/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

package com.incetro.fibonacci.common.di.app.module

import android.app.Application
import android.content.Context
import com.incetro.fibonacci.app.AppLauncher
import com.incetro.fibonacci.common.navigation.AppRouter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Application) {

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return context.applicationContext
    }

    @Provides
    @Singleton
    fun provideAppLauncher(
        router: AppRouter,
    ): AppLauncher {
        return AppLauncher(router)
    }
}