package com.example.simplifyinjections

import android.app.Application
import com.example.simplifyinjections.di.SimplifyInjectionsModuleInitializer

class SimplifyInjectionsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SimplifyInjectionsModuleInitializer().initialize()
    }
}
