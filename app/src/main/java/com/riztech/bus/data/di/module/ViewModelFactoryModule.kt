package com.riztech.bus.data.di.module

import androidx.lifecycle.ViewModelProvider
import com.riztech.bus.util.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun provideFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}