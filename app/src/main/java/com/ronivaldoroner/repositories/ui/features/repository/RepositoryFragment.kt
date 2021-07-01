package com.ronivaldoroner.repositories.ui.features.repository

import android.widget.Toast
import com.ronivaldoroner.repositories.R
import com.ronivaldoroner.repositories.databinding.RepositoryFragmentBinding
import com.ronivaldoroner.repositories.ui.base.BindableFragment
import com.ronivaldoroner.repositories.ui.commons.extensions.observe
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoryFragment : BindableFragment<RepositoryFragmentBinding>() {

    override val layoutId: Int = R.layout.repository_fragment

    private val viewModel: RepositoryViewModel by viewModel()

    override fun onDataBound(binding: RepositoryFragmentBinding) {
        initControllers(binding)
        initObservables()
    }

    private fun initControllers(binding: RepositoryFragmentBinding) {
        binding.viewModel = viewModel
        binding.wtRepositories.leftClickListener = {
            Toast.makeText(requireContext(), "LeftClick", Toast.LENGTH_LONG).show()
        }
    }

    private fun initObservables() {
        with(viewModel) {
            observe(repositories) {

            }
        }
    }

    companion object {

    }
}