package com.example.`simplify-injections`.di

import com.example.`simplify-injections`.di.SimplifyInjectionsModuleContext.addModule
import com.example.`simplify-injections`.di.SimplifyInjectionsModuleContext.clearAll
import com.example.`simplify-injections`.di.SimplifyInjectionsModuleContext.get
import com.example.`simplify-injections`.di.common.CommonModuleFactory
import com.example.`simplify-injections`.di.features.MainModuleFactory

internal class SimplifyInjectionsModuleInitializer {

    init {
        clearAll()
    }

    fun initialize() {
        addModule(CommonModuleFactory())
        addModule(MainModuleFactory(get(), get()))
    }
}
