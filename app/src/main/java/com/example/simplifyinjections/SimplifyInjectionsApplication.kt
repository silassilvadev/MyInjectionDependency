package com.example.simplifyinjections

import android.app.Application
import com.example.simplifyinjections.di.ModulesInitializer

class SimplifyInjectionsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ModulesInitializer().initialize()
    }
}
