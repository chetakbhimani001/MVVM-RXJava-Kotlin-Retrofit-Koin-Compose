package com.bhimani.rxjavademo

import android.app.Application
import com.bhimani.rxjavademo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DemoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@DemoApp)
            modules(appModule)
        }
    }
}