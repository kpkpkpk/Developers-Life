package com.example.devapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.devapp.R
import com.example.devapp.core.base.activity.BaseActivity
import com.example.devapp.databinding.ActivityMainBinding
import com.example.devapp.ui.components.fragments.HomeFragment
import com.example.devapp.ui.components.fragments.SavedFragment

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val navigationController: NavController by lazy {
        navHostFragment.navController
    }

    private val navHostFragment:NavHostFragment by lazy{
        supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
    }
    private val homeFragment by lazy{
        HomeFragment()
    }
    private val savedFragment by lazy{
        SavedFragment()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()

    }
    private fun navigationOnFragments(){
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.main_fragment -> supportFragmentManager.beginTransaction().replace()
            }
        }
    }

    override fun ActivityMainBinding.initialize() {
    }
}