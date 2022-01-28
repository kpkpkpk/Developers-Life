package com.example.devapp.core.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.devapp.R


open class BaseActivity<T : ViewDataBinding>(@LayoutRes private val layoutResId : Int) : AppCompatActivity() {

    private var _binding : T? = null

    // This can be accessed by the child fragments
    // Only valid between onCreateView and onDestroyView
    val binding : T get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this
        binding.initialize()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    /**
     * Here we may init UI components.
     * This method will be executed in parent [onCreate] method
     */
    open fun T.initialize(){}

}