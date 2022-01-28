package com.example.devapp.ui.components.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.devapp.R
import com.example.devapp.core.base.fragment.BaseFragment
import com.example.devapp.databinding.FragmentSavedBinding

class SavedFragment : BaseFragment<FragmentSavedBinding>(R.layout.fragment_saved) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun FragmentSavedBinding.initialize() {
        TODO("Not yet implemented")
    }
}