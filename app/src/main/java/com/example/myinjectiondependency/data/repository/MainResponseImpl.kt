package com.example.myinjectiondependency.data.repository

import com.example.myinjectiondependency.domain.model.MainResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

internal class MainResponseImpl : MainRepository {
    override suspend fun loadContracts(): MainResponse = withContext(Dispatchers.IO) {
        delay(timeMillis = DELAY_TO_REMOTE_SIMULATE)
        MainResponse("12345")
    }

    companion object {
        private const val DELAY_TO_REMOTE_SIMULATE = 2000L
    }
}
