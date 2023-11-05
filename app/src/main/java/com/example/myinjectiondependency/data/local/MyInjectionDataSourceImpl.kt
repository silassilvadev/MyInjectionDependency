package com.example.myinjectiondependency.data.local

import com.example.myinjectiondependency.data.Result

internal class MyInjectionDataSourceImpl : MyInjectionDataSource {

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
