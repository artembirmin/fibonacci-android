/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

package com.incetro.fibonacci.presentation.common.binding

import android.view.View
import androidx.databinding.BindingAdapter

object CommonBindingAdapters {

    @JvmStatic
    @BindingAdapter("android:visibility")
    fun isViewVisible(view: View, isVisible: Boolean) {
        if (isVisible) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }
}