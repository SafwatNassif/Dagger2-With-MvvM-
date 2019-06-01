package com.example.mvvmjsonplaceholder.di.component

import com.example.mvvmjsonplaceholder.MainActivity
import com.example.mvvmjsonplaceholder.di.module.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class BuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun provideMainActivity(): MainActivity

}