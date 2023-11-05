package com.example.simplifyinjections.di.common

import com.example.simplifyinjections.data.local.ContractDataSource
import com.example.simplifyinjections.data.local.ContractDataSourceImpl
import com.example.simplifyinjections.data.remote.ContractService
import com.example.simplifyinjections.data.remote.ContractServiceMock
import com.example.simplifyinjections.di.factory.ModuleFactory

internal class CommonModuleFactory : ModuleFactory {

    private val service: ContractService = ContractServiceMock()
    private val dataSource: ContractDataSource = ContractDataSourceImpl()

    override fun getInstance(clazz: Class<*>): Any? {
        return when (clazz) {
            ContractDataSource::class.java -> dataSource
            ContractService::class.java -> service
            else -> null
        }
    }
}
