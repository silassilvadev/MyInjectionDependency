package com.example.`simplify-injections`.di.factory

internal interface ModuleFactory {
    fun getInstance(clazz: Class<*>): Any?
}
