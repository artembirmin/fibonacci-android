package com.incetro.fibonacci.presentation.userstory.fibonaccicounter.statistic

import android.os.Bundle
import android.view.View
import com.incetro.fibonacci.R
import com.incetro.fibonacci.databinding.FragmentStatisticBinding
import com.incetro.fibonacci.entity.statistic.CounterStatistics
import com.incetro.fibonacci.presentation.base.fragment.BaseFragment
import com.incetro.fibonacci.presentation.userstory.fibonaccicounter.di.counter.CounterComponent
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class StatisticFragment : BaseFragment<FragmentStatisticBinding>(), StatisticView {
    override val layoutRes = R.layout.fragment_statistic

    @Inject
    @InjectPresenter
    lateinit var presenter: StatisticPresenter

    @ProvidePresenter
    fun providePresenter(): StatisticPresenter = presenter

    override fun inject() = CounterComponent.Manager.getComponent().inject(this)
    override fun release() = Unit

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun showStatistic(counterStatistics: CounterStatistics) {
        with(binding) {
            tvClicksCount.text = counterStatistics.clicksCount.toString()
            tvMax.text = counterStatistics.maxValue.toString()
            tvMin.text = counterStatistics.minValue.toString()
        }
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    companion object {
        fun newInstance() = StatisticFragment()
    }
}