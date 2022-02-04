package com.example.devapp.ui.components.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devapp.R
import com.example.devapp.core.base.fragment.BaseFragment
import com.example.devapp.data.model.GifModel
import com.example.devapp.databinding.FragmentHomeBinding
import com.example.devapp.ui.components.adapters.GifAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val rvAdapter: GifAdapter = GifAdapter()
    override fun FragmentHomeBinding.initialize() {
        binding.memesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        rvAdapter.submitList(
            mutableListOf(
                GifModel(
                    id = 17071,
                    description = "Собес \u003c -HR \u003c -разраб",
                    votes = 4,
                    author = "w3lifer",
                    date = "Jun 10,2020 9:52:37 AM",
                    gifURL = "http://static.devli.ru/public/images/gifs/202005/4491a587-061f-47aa-85cd-2082ff89ab97.gif",
                    gifSize = 8354847,
                    previewURL = "https://static.devli.ru/public/images/previews/202005/4491a587-061f-47aa-85cd-2082ff89ab97.jpg",
                    videoURL = "http://static.devli.ru/public/images/v/202005/4491a587-061f-47aa-85cd-2082ff89ab97.mp4",
                    videoPath = "/public/images/v/202005/4491a587-061f-47aa-85cd-2082ff89ab97.mp4",
                    videoSize = 861516,
                    type = "gif",
                    width = "480",
                    height = "300",
                    commentsCount = 0,
                    fileSize = 8354847,
                    canVote = false
                )
            )
        )
        binding.memesRecyclerView.adapter = rvAdapter
    }
}