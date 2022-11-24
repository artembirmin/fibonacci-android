/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

package com.incetro.fibonacci.presentation.userstory.fibonaccicounter.di.counter

import com.incetro.fibonacci.common.di.activity.ActivityComponent
import com.incetro.fibonacci.common.di.componentmanager.ComponentManager
import com.incetro.fibonacci.common.di.componentmanager.ComponentsManager
import com.incetro.fibonacci.common.di.scope.FeatureScope
import com.incetro.fibonacci.presentation.userstory.fibonaccicounter.counter.CounterFragment
import dagger.Component

@FeatureScope
@Component(
    dependencies = [ActivityComponent::class],
    modules = [
        CounterModule::class
    ]
)
interface CounterComponent {
    fun inject(counterFragment: CounterFragment)

    @Component.Builder
    interface Builder {
        fun activityComponent(component: ActivityComponent): Builder
        fun build(): CounterComponent
    }

    object Manager : ComponentManager<CounterComponent>(
        clazz = CounterComponent::class.java,
        createAndSave = {
            val componentManager = ComponentsManager.getInstance()
            val activityComponent = ActivityComponent.Manager.getComponent()
            val component = DaggerCounterComponent.builder()
                .activityComponent(activityComponent)
                .build()
            componentManager.addComponent(component)
        })
}