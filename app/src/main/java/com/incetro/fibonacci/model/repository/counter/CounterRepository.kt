package com.incetro.fibonacci.model.repository.counter

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface CounterRepository {
    fun observeCounter(): Observable<Int>
    fun incrementCounter(): Completable
    fun decrementCounter(): Completable
    fun getStatistics(): Single<Any>
}