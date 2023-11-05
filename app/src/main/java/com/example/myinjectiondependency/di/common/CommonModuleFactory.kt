package com.example.myinjectiondependency.di.common

import com.example.myinjectiondependency.data.local.MyInjectionDataSource
import com.example.myinjectiondependency.data.local.MyInjectionDataSourceImpl
import com.example.myinjectiondependency.data.remote.MyInjectionService
import com.example.myinjectiondependency.data.remote.MyInjectionServiceMock
import com.example.myinjectiondependency.di.factory.ModuleFactory

internal class CommonModuleFactory : ModuleFactory {

    private val service: MyInjectionService = MyInjectionServiceMock()
    private val dataSource: MyInjectionDataSource = MyInjectionDataSourceImpl()

    override fun getInstance(clazz: Class<*>): Any? {
        return when (clazz) {
            MyInjectionDataSource::class.java -> dataSource
            MyInjectionService::class.java -> service
            else -> null
        }
    }
}
