/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

package com.incetro.fibonacci.presentation.userstory.fibonaccicounter.counter

import com.incetro.fibonacci.common.navigation.AppRouter
import com.incetro.fibonacci.model.interactor.FibonacciCounterInteractor
import com.incetro.fibonacci.presentation.base.fragment.BasePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class CounterPresenter @Inject constructor(
    private val router: AppRouter,
    private val fibonacciCounterInteractor: FibonacciCounterInteractor
) : BasePresenter<CounterView>() {

    override fun onFirstViewAttach() {
        fibonacciCounterInteractor.observeCounter()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ viewState.showCounter(it) }, { viewState.showError(it) })
            .addDisposable()
    }

    fun onIncrementClick() {
        fibonacciCounterInteractor.incrementCounter()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ }, { viewState.showError(it) })
            .addDisposable()
    }

    fun onDecrementClick() {
        fibonacciCounterInteractor.decrementCounter()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ }, { viewState.showError(it) })
            .addDisposable()
    }

    override fun onBackPressed() {
        router.exit()
    }
}