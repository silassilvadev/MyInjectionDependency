package com.example.myinjectiondependency.data.repository

import com.example.myinjectiondependency.data.Result
import com.example.myinjectiondependency.data.local.MyInjectionDataSource
import com.example.myinjectiondependency.data.remote.MyInjectionService
import com.example.myinjectiondependency.domain.model.ContractResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class MainRepositoryImpl(
    private val dataSource: MyInjectionDataSource,
    private val service: MyInjectionService
) : MainRepository {

    override suspend fun getContracts(): Result<ContractResponse> = withContext(Dispatchers.IO) {
        getLocalContractOrNull() ?: service.getContract().apply(::makeSaveNewContract)
    }

    private fun getLocalContractOrNull() = (dataSource.getContract() as? Result.Success)?.run {
        Result.Success(ContractResponse(value))
    }

    private fun makeSaveNewContract(result: Result<ContractResponse>) {
        if (result is Result.Success) dataSource.putContract(result.value.contractId)
    }
}
