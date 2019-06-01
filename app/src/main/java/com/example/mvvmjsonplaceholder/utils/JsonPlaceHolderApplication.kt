package com.example.mvvmjsonplaceholder.utils

import android.app.Activity
import android.app.Application
import com.example.mvvmjsonplaceholder.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class JsonPlaceHolderApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.builder()
            .application(this)
            .build()
            .inject(this)


    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
}