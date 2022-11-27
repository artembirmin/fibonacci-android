package com.incetro.fibonacci.model.interactor

import com.incetro.fibonacci.entity.fibonaccicounter.CounterInfo
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface FibonacciCounterInteractor {
    fun incrementCounter(): Completable
    fun decrementCounter(): Completable
    fun observeCounter(): Observable<CounterInfo>
}