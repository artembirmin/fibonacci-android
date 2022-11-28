package com.incetro.fibonacci.model.repository.counter

import com.incetro.fibonacci.common.di.scope.FeatureScope
import com.incetro.fibonacci.entity.statistic.CounterStatistics
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject

@FeatureScope
class CounterRepositoryImpl @Inject constructor() : CounterRepository {
    private var counter: Int = 0
    private val counterStatistics = CounterStatistics()
    private var maxValueCopy = 0
    private var minValueCopy = 0
    private var clicksCountCopy = 0

    private val counterObservable: BehaviorSubject<Int> = BehaviorSubject.create<Int>()
        .apply { onNext(counter) }

    override fun observeCounter(): Observable<Int> {
        return counterObservable
    }

    override fun incrementCounter(): Completable {
        return Completable.fromAction {
            counterObservable.onNext(++counter)
            if (counter > counterStatistics.maxValue)
                maxValueCopy = counter
            clicksCountCopy++
        }
    }

    override fun decrementCounter(): Completable {
        return Completable.fromAction {
            counterObservable.onNext(--counter)
            if (counter < counterStatistics.minValue)
                minValueCopy = counter
            clicksCountCopy++
        }
    }

    override fun getStatistics(): Single<CounterStatistics> {
        return Single.just(
            counterStatistics.copy(
                maxValue = maxValueCopy, minValue = minValueCopy,
                clicksCount = clicksCountCopy
            )
        )
    }
}