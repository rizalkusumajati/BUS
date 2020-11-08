package com.riztech.bus.data.di.component

import android.content.Context
import com.riztech.bus.data.di.module.NetworkModule
import com.riztech.bus.data.di.module.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelFactoryModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory{
        fun context(@BindsInstance context: Context): AppComponent
    }
}