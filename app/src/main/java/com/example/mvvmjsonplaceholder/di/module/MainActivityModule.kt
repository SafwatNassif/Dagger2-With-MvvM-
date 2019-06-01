package com.example.mvvmjsonplaceholder.di.module

import com.example.mvvmjsonplaceholder.repository.MainActivityRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class MainActivityModule {

    @Provides
    fun provideRepository(retrofit: Retrofit): MainActivityRepository {
        return MainActivityRepository(retrofit)
    }


}