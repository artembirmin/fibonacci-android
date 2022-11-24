/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

@file:Suppress("FunctionName")

package com.incetro.fibonacci.common.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.incetro.fibonacci.presentation.userstory.fibonaccicounter.counter.CounterFragment
import com.incetro.fibonacci.presentation.userstory.fibonaccicounter.statistic.StatisticFragment

/**
 * App screens for navigation with Cicerone.
 */
object Screens {
    fun CounterScreen(): FragmentScreen =
        FragmentScreen("CounterScreen") {
            CounterFragment.newInstance()
        }

    fun StatisticScreen(): FragmentScreen =
        FragmentScreen("StatisticScreen") {
            StatisticFragment.newInstance()
        }
}