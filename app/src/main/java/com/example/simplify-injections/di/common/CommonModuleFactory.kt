package com.example.`simplify-injections`.di.common

import com.example.`simplify-injections`.data.local.ContractDataSource
import com.example.`simplify-injections`.data.local.ContractDataSourceImpl
import com.example.`simplify-injections`.data.remote.ContractService
import com.example.`simplify-injections`.data.remote.ContractServiceMock
import com.example.`simplify-injections`.di.factory.ModuleFactory

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
