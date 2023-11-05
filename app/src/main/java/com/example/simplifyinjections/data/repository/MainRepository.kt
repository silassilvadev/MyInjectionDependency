package com.example.simplifyinjections.data.repository

import com.example.simplifyinjections.data.Result
import com.example.simplifyinjections.domain.model.ContractResponse

internal interface MainRepository {
    suspend fun getContracts(): Result<ContractResponse>
}
