package com.example.myinjectiondependency.data.repository

import com.example.myinjectiondependency.data.Result
import com.example.myinjectiondependency.domain.model.ContractResponse

internal interface MainRepository {
    suspend fun getContracts(): Result<ContractResponse>
}
