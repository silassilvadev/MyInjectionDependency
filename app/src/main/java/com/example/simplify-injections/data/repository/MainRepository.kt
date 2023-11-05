package com.example.`simplify-injections`.data.repository

import com.example.`simplify-injections`.data.Result
import com.example.`simplify-injections`.domain.model.ContractResponse

internal interface MainRepository {
    suspend fun getContracts(): Result<ContractResponse>
}
