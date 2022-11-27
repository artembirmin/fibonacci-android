package com.incetro.fibonacci.model.interactor.statistic

import com.incetro.fibonacci.common.di.scope.FeatureScope
import com.incetro.fibonacci.entity.statistic.CounterStatistics
import com.incetro.fibonacci.model.interactor.fibonacci.FibonacciCounterInteractor
import com.incetro.fibonacci.model.repository.counter.CounterRepository
import com.incetro.fibonacci.model.repository.fibonacci.FibonacciRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

@FeatureScope
class StatisticCounterInteractorImpl @Inject constructor(
    private val counterRepository: CounterRepository
) : StatisticCounterInteractor {

    override fun getStatistics(): Single<CounterStatistics> {
        return counterRepository.getStatistics()
    }
}