package com.example.simplifyinjections.domain.usecase

import com.example.simplifyinjections.data.Result
import com.example.simplifyinjections.data.repository.MainRepository
import com.example.simplifyinjections.domain.model.ContractResponse

internal class MainUseCase(private val repository: MainRepository) {
    suspend operator fun invoke(): Result<ContractResponse> {
        return repository.getContracts()
    }
}
