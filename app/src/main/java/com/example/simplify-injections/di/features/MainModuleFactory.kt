package com.example.`simplify-injections`.di.features

import com.example.`simplify-injections`.data.local.ContractDataSource
import com.example.`simplify-injections`.data.remote.ContractService
import com.example.`simplify-injections`.data.repository.MainRepository
import com.example.`simplify-injections`.data.repository.MainRepositoryImpl
import com.example.`simplify-injections`.di.factory.ModuleFactory
import com.example.`simplify-injections`.domain.usecase.MainUseCase
import com.example.`simplify-injections`.ui.main.MainViewModel

internal class MainModuleFactory(
    private val dataSource: ContractDataSource,
    private val service: ContractService
) : ModuleFactory {

    private val repository: MainRepository by lazy {
        MainRepositoryImpl(dataSource, service)
    }
    private val useCase: MainUseCase by lazy {
        MainUseCase(repository)
    }
    private val viewModel: MainViewModel by lazy {
        MainViewModel(useCase)
    }

    override fun getInstance(clazz: Class<*>): Any? {
        return when (clazz) {
            MainRepository::class.java -> repository
            MainUseCase::class.java -> useCase
            MainViewModel::class.java -> viewModel
            else -> null
        }
    }
}
