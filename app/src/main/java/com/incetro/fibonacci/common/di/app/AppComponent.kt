/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

package com.incetro.fibonacci.common.di.app

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.incetro.fibonacci.app.App
import com.incetro.fibonacci.app.AppLauncher
import com.incetro.fibonacci.common.di.app.module.AppModule
import com.incetro.fibonacci.common.di.app.module.AppNavigationModule
import com.incetro.fibonacci.common.di.app.module.CommonAppModule
import com.incetro.fibonacci.common.manager.ResourcesManager
import com.incetro.fibonacci.common.navigation.AppRouter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CommonAppModule::class,
        AppNavigationModule::class,
    ]
)
interface AppComponent {

    fun inject(app: App)

    // AppModule
    fun provideContext(): Context
    fun provideAppLauncher(): AppLauncher

    // CommonAppModule

    // AppNavigationModule
    fun provideNavigationHolder(): NavigatorHolder
    fun provideAppRouter(): AppRouter

    // Other
    fun provideResourcesManager(): ResourcesManager

    @Component.Builder
    interface Builder {
        fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }
}