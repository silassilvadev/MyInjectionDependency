package com.example.myinjectiondependency

import android.app.Application
import com.example.myinjectiondependency.di.MyInjectionModuleInitializer

class MyInjectionDependencyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MyInjectionModuleInitializer().initialize()
    }
}
