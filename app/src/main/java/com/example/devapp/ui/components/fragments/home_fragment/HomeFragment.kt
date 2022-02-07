package com.example.devapp.ui.components.fragments.home_fragment

import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devapp.R
import com.example.devapp.core.base.fragment.BaseFragment
import com.example.devapp.domain.model.GifModel
import com.example.devapp.databinding.FragmentHomeBinding
import com.example.devapp.ui.components.adapters.GifAdapter
import com.example.devapp.ui.components.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val rvAdapter: GifAdapter = GifAdapter()
//    private val homeViewModel: HomeViewModel by viewModels()
    override fun FragmentHomeBinding.initialize() {
        binding.memesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
//        rvAdapter.submitList(
//        )
        binding.memesRecyclerView.adapter = rvAdapter
    }
}