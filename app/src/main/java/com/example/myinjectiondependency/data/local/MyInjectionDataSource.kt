package com.example.myinjectiondependency.data.local

import com.example.myinjectiondependency.data.Result

internal interface MyInjectionDataSource {
    fun getContract(): Result<String>
    fun putContract(contractId: String)
}
