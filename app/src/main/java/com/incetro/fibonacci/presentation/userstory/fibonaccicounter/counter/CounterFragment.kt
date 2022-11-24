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
import com.incetro.fibonacci.entity.fibonaccicounter.CounterInfo
import com.incetro.fibonacci.presentation.base.fragment.BaseFragment
import com.incetro.fibonacci.presentation.userstory.fibonaccicounter.di.counter.CounterComponent
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
            btnIncrement.setOnClickListener { presenter.onIncrementClick() }
            btnDecrement.setOnClickListener { presenter.onDecrementClick() }
        }
    }

    private fun showStatistic() {
        binding.btnStatistic.setOnClickListener({ presenter })
    }

    override fun showCounter(counterInfo: CounterInfo) {
        with(binding) {
            tvCounter.text = counterInfo.counter.toString()

            val fibStatusResId =
                if (counterInfo.isFibonacci) R.string.agreement
                else R.string.disagreement
            tvFib.setText(fibStatusResId)
        }
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    companion object {
        fun newInstance() = CounterFragment()
    }


}