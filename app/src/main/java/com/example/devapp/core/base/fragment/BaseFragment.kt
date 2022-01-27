package com.example.devapp.core.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

open class BaseFragment<T : ViewDataBinding>(@LayoutRes private val layoutResId : Int) : Fragment() {

    private var _binding : T? = null


    // This can be accessed by the child fragments
    // Only valid between onCreateView and onDestroyView
    val binding : T get() = _binding!!
    protected val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)

        binding.lifecycleOwner = viewLifecycleOwner

        // Optional
        binding.initialize()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Removing binding to avoid memory leak
        _binding = null
    }

    /**
     * Here we may init UI components.
     * This method will be executed in parent [onCreateView] method
     */
    open fun T.initialize(){}

}