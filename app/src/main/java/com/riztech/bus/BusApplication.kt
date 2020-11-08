package com.riztech.bus

import android.app.Application
import com.riztech.bus.data.di.component.AppComponent
import com.riztech.bus.data.di.component.DaggerAppComponent
import com.riztech.bus.data.sp.LocalValue

class BusApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().context(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()

        LocalValue.init(this)
    }

}