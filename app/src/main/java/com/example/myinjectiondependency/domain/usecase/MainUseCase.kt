package com.example.myinjectiondependency.domain.usecase

import com.example.myinjectiondependency.data.Result
import com.example.myinjectiondependency.data.repository.MainRepository
import com.example.myinjectiondependency.domain.model.ContractResponse

internal class MainUseCase(private val repository: MainRepository) {
    suspend operator fun invoke(): Result<ContractResponse> {
        return repository.getContracts()
    }
}
