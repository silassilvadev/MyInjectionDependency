package com.example.`simplify-injections`.data.remote

import com.example.`simplify-injections`.data.Result
import com.example.`simplify-injections`.domain.model.ContractResponse
import retrofit2.http.GET

internal interface ContractService {
    @GET("contract_id")
    suspend fun getContract(): Result<ContractResponse>
}
