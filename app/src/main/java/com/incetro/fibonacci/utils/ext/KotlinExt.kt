/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

package com.incetro.fibonacci.utils.ext

fun <R> Boolean.ifTrue(block: (Boolean) -> R): Boolean {
    if (this) run(block)
    return this
}

fun <R> Boolean.ifFalse(block: (Boolean) -> R): Boolean {
    if (!this) run(block)
    return this
}

fun String.removeWhitespaces() = filter { !it.isWhitespace() }