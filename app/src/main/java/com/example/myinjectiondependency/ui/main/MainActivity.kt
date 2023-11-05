package com.example.myinjectiondependency.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.myinjectiondependency.R
import com.example.myinjectiondependency.data.local.MyInjectionDataSource
import com.example.myinjectiondependency.data.local.MyInjectionDataSourceImpl
import com.example.myinjectiondependency.data.remote.MyInjectionService
import com.example.myinjectiondependency.data.remote.MyInjectionServiceMock
import com.example.myinjectiondependency.data.repository.MainRepository
import com.example.myinjectiondependency.data.repository.MainRepositoryImpl
import com.example.myinjectiondependency.domain.usecase.MainUseCase

class MainActivity : AppCompatActivity() {

    private val contractText: TextView by lazy {
        findViewById(R.id.main_contract_text)
    }

    private val contractLoading: ProgressBar by lazy {
        findViewById(R.id.main_loading)
    }

    private val loadContractButton: Button by lazy {
        findViewById(R.id.main_button_load_contract)
    }

    private val service: MyInjectionService = MyInjectionServiceMock()
    private val dataSource: MyInjectionDataSource = MyInjectionDataSourceImpl()
    private val repository: MainRepository = MainRepositoryImpl(dataSource, service)
    private val useCase = MainUseCase(repository)
    private val mainViewModel: MainViewModel by lazy {
        MainViewModel(useCase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
        initObserver()
    }

    private fun initListeners() {
        loadContractButton.setOnClickListener {
            updateLoading(true)
            loadContracts()
        }
    }

    private fun initObserver() {
        mainViewModel.getContractsLiveData.observe(this) { response ->
            updateLoading(false)
            makeResponse(response)
        }
    }

    private fun loadContracts() {
        mainViewModel.loadContracts()
    }

    private fun makeResponse(response: MainState) {
        contractText.text = (response as? MainState.Success)?.let {
            getString(R.string.main_contract_text, it.contractId)
        } ?: run {
            (response as? MainState.Failure)?.message ?: getString(R.string.main_contract_text_error)
        }
    }

    private fun updateLoading(isLoading: Boolean) {
        contractText.isInvisible = isLoading
        contractLoading.isVisible = isLoading
    }
}