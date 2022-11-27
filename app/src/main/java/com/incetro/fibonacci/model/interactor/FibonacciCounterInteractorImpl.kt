package com.incetro.fibonacci.model.interactor

import com.incetro.fibonacci.common.di.scope.FeatureScope
import com.incetro.fibonacci.entity.fibonaccicounter.CounterInfo
import com.incetro.fibonacci.model.repository.counter.CounterRepository
import com.incetro.fibonacci.model.repository.fibonacci.FibonacciRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

@FeatureScope
class FibonacciCounterInteractorImpl @Inject constructor(
    private val counterRepository: CounterRepository,
    private val fibonacciRepository: FibonacciRepository
) : FibonacciCounterInteractor {

    override fun observeCounter(): Observable<CounterInfo> {
        return counterRepository.observeCounter()
            .flatMapSingle { counter ->
                fibonacciRepository.fibonacciNumberCheck(counter)
                    .map { isFibonacci ->
                        CounterInfo(counter, isFibonacci)
                    }
            }
    }

    override fun incrementCounter(): Completable {
        return counterRepository.incrementCounter()
    }

    override fun decrementCounter(): Completable {
        return counterRepository.decrementCounter()
    }
}