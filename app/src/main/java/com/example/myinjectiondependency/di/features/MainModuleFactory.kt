package com.example.myinjectiondependency.di.features

import com.example.myinjectiondependency.data.local.MyInjectionDataSource
import com.example.myinjectiondependency.data.remote.MyInjectionService
import com.example.myinjectiondependency.data.repository.MainRepository
import com.example.myinjectiondependency.data.repository.MainRepositoryImpl
import com.example.myinjectiondependency.di.factory.ModuleFactory
import com.example.myinjectiondependency.domain.usecase.MainUseCase
import com.example.myinjectiondependency.ui.main.MainViewModel

internal class MainModuleFactory(
    private val dataSource: MyInjectionDataSource,
    private val service: MyInjectionService
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
