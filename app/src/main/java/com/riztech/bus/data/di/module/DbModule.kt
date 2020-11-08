package com.riztech.bus.data.di.module

import android.content.Context
import androidx.room.Room
import com.riztech.bus.data.db.BusDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Singleton
    @Provides
    fun provideDb(app: Context) = Room.databaseBuilder(app, BusDatabase::class.java, "busdatabase").build()
}