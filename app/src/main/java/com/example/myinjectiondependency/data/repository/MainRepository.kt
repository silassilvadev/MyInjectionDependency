package com.example.myinjectiondependency.data.repository

import com.example.myinjectiondependency.domain.model.MainResponse

internal interface MainRepository {
    suspend fun loadContracts(): MainResponse
}
