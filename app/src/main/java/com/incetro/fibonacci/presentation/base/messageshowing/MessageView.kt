/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

package com.incetro.fibonacci.presentation.base.messageshowing

import androidx.annotation.StringRes
import com.incetro.fibonacci.R
import com.incetro.fibonacci.entity.errors.AppError
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(OneExecutionStateStrategy::class)
interface MessageView {

    fun showError(error: AppError)

    fun showError(error: Throwable)

    fun showMessageByAlertDialog(
        @StringRes title: Int? = null,
        @StringRes message: Int? = null,
        @StringRes positiveText: Int = R.string.alert_button_ok,
        @StringRes negativeText: Int? = null,
        onPositiveButtonClick: (() -> Unit)? = null,
        onNegativeButtonClick: (() -> Unit)? = null,
        onDismiss: (() -> Unit)? = null
    )
}