package com.incetro.fibonacci.model.interactor.statistic

import com.incetro.fibonacci.entity.statistic.CounterStatistics
import io.reactivex.rxjava3.core.Single

interface StatisticCounterInteractor {
    fun getStatistics(): Single<CounterStatistics>
}