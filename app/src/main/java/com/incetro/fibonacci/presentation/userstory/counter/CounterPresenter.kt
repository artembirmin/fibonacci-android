/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

package com.incetro.fibonacci.presentation.userstory.counter

import com.incetro.fibonacci.common.navigation.AppRouter
import com.incetro.fibonacci.presentation.base.fragment.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class CounterPresenter @Inject constructor(
    private val router: AppRouter
) : BasePresenter<CounterView>() {

    override fun onFirstViewAttach() {

    }

    override fun onBackPressed() {
        router.exit()
    }
}