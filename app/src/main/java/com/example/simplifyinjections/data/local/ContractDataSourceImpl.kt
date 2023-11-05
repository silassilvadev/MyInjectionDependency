package com.example.simplifyinjections.data.local

import com.example.simplifyinjections.data.Result

internal class ContractDataSourceImpl : ContractDataSource {

    private var currentContract: String? = null

    override fun getContract(): Result<String> {
        return currentContract?.let {
            Result.Success(it)
        } ?: Result.Error(NoSuchElementException())
    }

    override fun putContract(contractId: String) {
        currentContract = contractId
    }
}
