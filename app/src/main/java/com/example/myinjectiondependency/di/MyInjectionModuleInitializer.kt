package com.example.myinjectiondependency.di

import com.example.myinjectiondependency.di.MyInjectionModuleContext.addModule
import com.example.myinjectiondependency.di.MyInjectionModuleContext.clearAll
import com.example.myinjectiondependency.di.MyInjectionModuleContext.get
import com.example.myinjectiondependency.di.common.CommonModuleFactory
import com.example.myinjectiondependency.di.features.MainModuleFactory

internal class MyInjectionModuleInitializer {

    init {
        clearAll()
    }

    fun initialize() {
        addModule(CommonModuleFactory())
        addModule(MainModuleFactory(get(), get()))
    }
}
