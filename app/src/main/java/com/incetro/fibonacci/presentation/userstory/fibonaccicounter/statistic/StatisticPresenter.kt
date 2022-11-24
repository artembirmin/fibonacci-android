package com.incetro.fibonacci.presentation.userstory.fibonaccicounter.statistic

import com.incetro.fibonacci.common.navigation.AppRouter
import com.incetro.fibonacci.presentation.base.fragment.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class StatisticPresenter @Inject constructor(
    private val router: AppRouter
) : BasePresenter<StatisticView>() {


    override fun onBackPressed() {
        router.exit()
    }


}