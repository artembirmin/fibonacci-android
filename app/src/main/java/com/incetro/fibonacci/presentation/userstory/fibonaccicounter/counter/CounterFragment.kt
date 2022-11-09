/*
 * Fibonacci
 *
 * Created by artembirmin on 7/11/2022.
 */

package com.incetro.fibonacci.presentation.userstory.fibonaccicounter.counter

import android.os.Bundle
import android.view.View
import com.incetro.fibonacci.R
import com.incetro.fibonacci.databinding.FragmentCounterBinding
import com.incetro.fibonacci.presentation.base.fragment.BaseFragment
import com.incetro.fibonacci.presentation.userstory.fibonaccicounter.di.CounterComponent
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class CounterFragment : BaseFragment<FragmentCounterBinding>(), CounterView {

    override val layoutRes = R.layout.fragment_counter

    @Inject
    @InjectPresenter
    lateinit var presenter: CounterPresenter

    @ProvidePresenter
    fun providePresenter(): CounterPresenter = presenter

    override fun inject() = CounterComponent.Manager.getComponent().inject(this)
    override fun release() = CounterComponent.Manager.releaseComponent()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        with(binding) {

        }
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    companion object {
        fun newInstance() = CounterFragment()
    }
}