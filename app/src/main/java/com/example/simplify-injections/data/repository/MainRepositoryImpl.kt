package com.example.`simplify-injections`.data.repository

import com.example.`simplify-injections`.data.Result
import com.example.`simplify-injections`.data.local.ContractDataSource
import com.example.`simplify-injections`.data.remote.ContractService
import com.example.`simplify-injections`.domain.model.ContractResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class MainRepositoryImpl(
    private val dataSource: ContractDataSource,
    private val service: ContractService
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
