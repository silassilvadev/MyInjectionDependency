package com.example.simplifyinjections.data.local

import com.example.simplifyinjections.data.Result

internal interface ContractDataSource {
    fun getContract(): Result<String>
    fun putContract(contractId: String)
}
