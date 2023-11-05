package com.example.myinjectiondependency.di.factory

internal interface ModuleFactory {
    fun getInstance(clazz: Class<*>): Any?
}
