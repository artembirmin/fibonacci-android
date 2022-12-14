/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

package com.incetro.fibonacci.common.di.activity

import android.content.Context
import com.incetro.fibonacci.app.AppActivity
import com.incetro.fibonacci.common.di.app.AppComponent
import com.incetro.fibonacci.common.di.componentmanager.ComponentManager
import com.incetro.fibonacci.common.di.componentmanager.ComponentsManager
import com.incetro.fibonacci.common.di.scope.ActivityScope
import com.incetro.fibonacci.common.manager.ResourcesManager
import com.incetro.fibonacci.common.navigation.AppRouter
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [
        ActivityModule::class
    ]
)
interface ActivityComponent {
    fun inject(appActivity: AppActivity)

    // AppModule
    fun provideContext(): Context

    // AppNavigationModule from AppComponent
    fun provideAppRouter(): AppRouter

    // Other
    fun provideResourcesManager(): ResourcesManager

    @Component.Builder
    interface Builder {
        fun appComponent(component: AppComponent): Builder
        fun activityModule(activityModule: ActivityModule): Builder
        fun build(): ActivityComponent
    }

    object Manager : ComponentManager<ActivityComponent>(
        clazz = ActivityComponent::class.java,
        createAndSave = {
            val componentManager = ComponentsManager.getInstance()
            val activityComponent = DaggerActivityComponent.builder()
                .appComponent(componentManager.applicationComponent)
                .activityModule(ActivityModule())
                .build()

            componentManager.addComponent(activityComponent)
        })
}