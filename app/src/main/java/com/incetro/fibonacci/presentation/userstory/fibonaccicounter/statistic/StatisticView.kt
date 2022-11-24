package com.incetro.fibonacci.presentation.userstory.fibonaccicounter.statistic

import com.incetro.fibonacci.presentation.base.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface StatisticView : BaseView {
    fun showStatistic()
}