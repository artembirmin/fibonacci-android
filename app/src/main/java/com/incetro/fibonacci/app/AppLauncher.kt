/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

package com.incetro.fibonacci.app

import com.incetro.fibonacci.common.navigation.AppRouter
import com.incetro.fibonacci.common.navigation.Screens

class AppLauncher(
    private val router: AppRouter,
) {
    /**
     *  Initialized and launches application.
     */
    fun start() {
        router.newRootScreen(Screens.CounterScreen())
    }
}