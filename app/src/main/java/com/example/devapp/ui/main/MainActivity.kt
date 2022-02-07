package com.example.devapp.ui.main

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.devapp.R
import com.example.devapp.core.base.activity.BaseActivity
import com.example.devapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val navigationController: NavController by lazy {
        navHostFragment.navController

    }

    private val navHostFragment: NavHostFragment by lazy {
        supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

    }

    override fun ActivityMainBinding.initialize() {
        navigationController.graph =
            navigationController.navInflater.inflate(R.navigation.nav_graph)
        binding.bottomNavigation.setupWithNavController(navigationController)
    }
}