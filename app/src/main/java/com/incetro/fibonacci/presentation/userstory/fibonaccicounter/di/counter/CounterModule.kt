/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

package com.incetro.fibonacci.presentation.userstory.fibonaccicounter.di.counter

import com.incetro.fibonacci.common.di.scope.FeatureScope
import com.incetro.fibonacci.model.interactor.fibonacci.FibonacciCounterInteractor
import com.incetro.fibonacci.model.interactor.fibonacci.FibonacciCounterInteractorImpl
import com.incetro.fibonacci.model.repository.counter.CounterRepository
import com.incetro.fibonacci.model.repository.counter.CounterRepositoryImpl
import com.incetro.fibonacci.model.repository.fibonacci.FibonacciRepository
import com.incetro.fibonacci.model.repository.fibonacci.FibonacciRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class CounterModule {
    @Binds
    @FeatureScope
    abstract fun provideCounterRepository(counterRepositoryImpl: CounterRepositoryImpl): CounterRepository

    @Binds
    @FeatureScope
    abstract fun provideFibonacciRepository(fibonacciRepositoryImpl: FibonacciRepositoryImpl): FibonacciRepository

    @Binds
    @FeatureScope
    abstract fun provideFibonacciCounterInteractor(
        fibonacciCounterInteractorImpl: FibonacciCounterInteractorImpl
    ): FibonacciCounterInteractor
}