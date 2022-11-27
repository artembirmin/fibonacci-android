package com.incetro.fibonacci.model.repository.fibonacci

import com.incetro.fibonacci.common.di.scope.FeatureScope
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import kotlin.math.sqrt

@FeatureScope
class FibonacciRepositoryImpl @Inject constructor() : FibonacciRepository {

    private fun Int.isPerfectSquare(): Boolean {
        val sqrt = sqrt(this.toDouble()).toInt()
        return sqrt * sqrt == this
    }

    override fun fibonacciNumberCheck(number: Int): Single<Boolean> {
        Thread.sleep(1000)
        val firstCondition = (5 * number * number + 4).isPerfectSquare()
        val secondCondition = (5 * number * number - 4).isPerfectSquare()
        return Single.just((firstCondition || secondCondition) && number >= 0)
    }
}