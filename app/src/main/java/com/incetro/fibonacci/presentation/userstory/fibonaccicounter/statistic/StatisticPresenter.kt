package com.incetro.fibonacci.presentation.userstory.fibonaccicounter.statistic

import com.incetro.fibonacci.common.navigation.AppRouter
import com.incetro.fibonacci.model.interactor.statistic.StatisticCounterInteractor
import com.incetro.fibonacci.presentation.base.fragment.BasePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class StatisticPresenter @Inject constructor(
    private val router: AppRouter,
    private val statisticCounterInteractor: StatisticCounterInteractor
) : BasePresenter<StatisticView>() {

    override fun onFirstViewAttach() {
        statisticCounterInteractor.getStatistics()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ viewState.showStatistic(it) }, {viewState.showError(it)})
            .addDisposable()
    }

    override fun onBackPressed() {
        router.exit()
    }
}