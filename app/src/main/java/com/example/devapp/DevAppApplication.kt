package com.example.devapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DevAppApplication : Application() {
//    lateinit var appComponent: AppComponent
//        private set
//
//    override fun onCreate() {
//        super.onCreate()
//        appComponent = DaggerAppComponent.builder()
////                .context(ApplicationModule(context = this))
//            .build()
//    }
}