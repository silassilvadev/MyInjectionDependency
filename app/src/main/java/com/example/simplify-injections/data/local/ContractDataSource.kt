package com.example.`simplify-injections`.data.local

import com.example.`simplify-injections`.data.Result

internal interface ContractDataSource {
    fun getContract(): Result<String>
    fun putContract(contractId: String)
}
