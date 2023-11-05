package com.example.simplifyinjections.di

import com.example.simplifyinjections.di.ModulesContext.addModule
import com.example.simplifyinjections.di.ModulesContext.clearAll
import com.example.simplifyinjections.di.ModulesContext.get
import com.example.simplifyinjections.di.common.CommonModuleFactory
import com.example.simplifyinjections.di.features.MainModuleFactory

internal class ModulesInitializer {

    init {
        clearAll()
    }

    fun initialize() {
        addModule(CommonModuleFactory())
        addModule(MainModuleFactory(get(), get()))
    }
}
