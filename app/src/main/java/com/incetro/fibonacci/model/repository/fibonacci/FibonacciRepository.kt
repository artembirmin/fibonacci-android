package com.incetro.fibonacci.model.repository.fibonacci

import io.reactivex.rxjava3.core.Single

interface FibonacciRepository {
    fun fibonacciNumberCheck(number: Int): Single<Boolean>
}