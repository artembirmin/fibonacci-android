/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

package com.incetro.fibonacci.common.di.app.module

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Cicerone.Companion.create
import com.github.terrakok.cicerone.NavigatorHolder
import com.incetro.fibonacci.common.navigation.AppRouter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppNavigationModule {
    @Provides
    @Singleton
    fun provideAppCicerone(): Cicerone<AppRouter> = create(AppRouter())

    @Provides
    @Singleton
    fun provideAppRouter(appCicerone: Cicerone<AppRouter>): AppRouter = appCicerone.router

    @Provides
    @Singleton
    fun provideNavigationHolder(appCicerone: Cicerone<AppRouter>): NavigatorHolder =
        appCicerone.getNavigatorHolder()
}