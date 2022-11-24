package com.incetro.fibonacci.presentation.userstory.fibonaccicounter.statistic

import android.os.Bundle
import android.view.View
import com.incetro.fibonacci.R
import com.incetro.fibonacci.databinding.FragmentStatisticBinding
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
    override fun release() = CounterComponent.Manager.releaseComponent()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {

    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    companion object {
        fun newInstance() = StatisticFragment()
    }

    override fun showStatistic() {

    }
}