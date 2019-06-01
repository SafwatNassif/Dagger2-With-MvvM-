package com.example.mvvmjsonplaceholder.di.component


import com.example.mvvmjsonplaceholder.di.module.NetworkModule
import com.example.mvvmjsonplaceholder.di.module.ViewModelModule
import com.example.mvvmjsonplaceholder.utils.JsonPlaceHolderApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        BuilderModule::class]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: JsonPlaceHolderApplication): Builder

        fun build(): ApplicationComponent
    }


    fun inject(application: JsonPlaceHolderApplication)
}
