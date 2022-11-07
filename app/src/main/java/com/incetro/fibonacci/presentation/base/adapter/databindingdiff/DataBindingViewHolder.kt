/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

package com.incetro.fibonacci.presentation.base.adapter.databindingdiff

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * [RecyclerView.ViewHolder] implementation using DataBinding.
 * [B] is type of DataBinding generated class for your [DataBindingViewItem] layout.
 * [binding] is instance of [B].
 */
class DataBindingViewHolder<B : ViewDataBinding>(val binding: B) :
    RecyclerView.ViewHolder(binding.root)
