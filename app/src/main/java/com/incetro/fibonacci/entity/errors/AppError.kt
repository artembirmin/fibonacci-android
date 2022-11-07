/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

package com.incetro.fibonacci.entity.errors

data class AppError(
    val error: Throwable,
    val payload: Any? = null
)