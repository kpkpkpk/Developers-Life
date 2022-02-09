package com.example.devapp.ui.components.fragments.home_fragment

import android.widget.Toast
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devapp.R
import com.example.devapp.core.base.fragment.BaseFragment
import com.example.devapp.domain.model.GifModel
import com.example.devapp.databinding.FragmentHomeBinding
import com.example.devapp.ui.components.adapters.GifAdapter
import com.example.devapp.ui.components.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val rvAdapter: GifAdapter = GifAdapter()
    private val homeViewModel: HomeViewModel by viewModels()
    override fun FragmentHomeBinding.initialize() {
        binding.memesRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.btn.setOnClickListener {
            homeViewModel.nextPage("latest")
        }
//        rvAdapter.submitList(
//        )
//        homeViewModel.state
//            .flowWithLifecycle(lifecycle, Lifecycle.State.CREATED)
//            .onEach {
//
//            }.launchIn(lifecycleScope)
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
//            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.state.collectLatest {
                    when {
                        it.error.isNotBlank() -> {
                            Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                        }
                        it.memesList.isNotEmpty() -> {
                            rvAdapter.submitList(it.memesList)
                            binding.memesRecyclerView.adapter = rvAdapter
                        }
                        else -> {
                            //
                        }
                    }
                }
//            }
        }
        homeViewModel.getListOfMemes("latest", homeViewModel.page, pageSize = 10)
    }
}

