package com.example.simplifyinjections.di.factory

internal interface ModuleFactory {
    fun getInstance(clazz: Class<*>): Any?
}
