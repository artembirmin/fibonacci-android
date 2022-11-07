/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

package com.incetro.fibonacci.presentation.base.adapter.databindingdiff

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Displayed item in [RecyclerView].
 * Used together with [DataBindingDiffAdapter].
 * [B] is type of DataBinding generated class for your [DataBindingViewItem] layout.
 */
interface DataBindingViewItem<B : ViewDataBinding> {

    @LayoutRes
    fun getLayoutId(): Int

    /**
     * Binds item to [holder].
     */
    fun bind(holder: DataBindingViewHolder<B>)

    fun onPositionChanged(position: Int, size: Int) {}
}