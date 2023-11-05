package com.example.myinjectiondependency.data.remote

import com.example.myinjectiondependency.data.Result
import com.example.myinjectiondependency.domain.model.ContractResponse
import retrofit2.http.GET

internal interface MyInjectionService {
    @GET("contract_id")
    suspend fun getContract(): Result<ContractResponse>
}
