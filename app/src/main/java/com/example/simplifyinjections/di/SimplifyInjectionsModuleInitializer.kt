package com.example.simplifyinjections.di

import com.example.simplifyinjections.di.SimplifyInjectionsModuleContext.addModule
import com.example.simplifyinjections.di.SimplifyInjectionsModuleContext.clearAll
import com.example.simplifyinjections.di.SimplifyInjectionsModuleContext.get
import com.example.simplifyinjections.di.common.CommonModuleFactory
import com.example.simplifyinjections.di.features.MainModuleFactory

internal class SimplifyInjectionsModuleInitializer {

    init {
        clearAll()
    }

    fun initialize() {
        addModule(CommonModuleFactory())
        addModule(MainModuleFactory(get(), get()))
    }
}
