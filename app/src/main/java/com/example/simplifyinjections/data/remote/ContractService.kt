package com.example.simplifyinjections.data.remote

import com.example.simplifyinjections.data.Result
import com.example.simplifyinjections.domain.model.ContractResponse
import retrofit2.http.GET

internal interface ContractService {
    @GET("contract_id")
    suspend fun getContract(): Result<ContractResponse>
}
