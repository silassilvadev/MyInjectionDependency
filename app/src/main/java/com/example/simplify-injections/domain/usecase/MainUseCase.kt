package com.example.`simplify-injections`.domain.usecase

import com.example.`simplify-injections`.data.Result
import com.example.`simplify-injections`.data.repository.MainRepository
import com.example.`simplify-injections`.domain.model.ContractResponse

internal class MainUseCase(private val repository: MainRepository) {
    suspend operator fun invoke(): Result<ContractResponse> {
        return repository.getContracts()
    }
}
