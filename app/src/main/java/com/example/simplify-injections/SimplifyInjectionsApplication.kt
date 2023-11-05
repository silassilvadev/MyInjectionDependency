package com.example.`simplify-injections`

import android.app.Application
import com.example.`simplify-injections`.di.SimplifyInjectionsModuleInitializer

class SimplifyInjectionsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SimplifyInjectionsModuleInitializer().initialize()
    }
}
