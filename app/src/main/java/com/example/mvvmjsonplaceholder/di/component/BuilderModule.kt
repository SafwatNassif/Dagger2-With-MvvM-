package com.example.mvvmjsonplaceholder.di.component

import com.example.mvvmjsonplaceholder.di.module.MainActivityModule
import com.example.mvvmjsonplaceholder.ui.mainscreen.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class BuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun provideMainActivity(): MainActivity

}