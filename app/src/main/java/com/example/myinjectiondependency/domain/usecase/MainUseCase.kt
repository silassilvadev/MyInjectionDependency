package com.example.myinjectiondependency.domain.usecase

import com.example.myinjectiondependency.data.repository.MainRepository
import com.example.myinjectiondependency.domain.model.MainResponse

internal class MainUseCase(private val repository: MainRepository) {
    suspend operator fun invoke(): MainResponse {
        return repository.loadContracts()
    }
}
