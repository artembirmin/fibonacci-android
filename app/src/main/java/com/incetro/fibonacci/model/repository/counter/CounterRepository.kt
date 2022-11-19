package com.incetro.fibonacci.model.repository.counter

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface CounterRepository {
    fun observeCounter(): Observable<Int>
    fun incrementCounter(): Completable
    fun decrementCounter(): Completable

}