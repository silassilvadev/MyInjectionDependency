package com.example.myinjectiondependency.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myinjectiondependency.domain.model.MainResponse
import com.example.myinjectiondependency.domain.usecase.MainUseCase
import kotlinx.coroutines.launch

internal class MainViewModel(private val useCase: MainUseCase) : ViewModel() {

    private val _getContractsLiveData = MutableLiveData<MainResponse>()
    val getContractsLiveData: LiveData<MainResponse> = _getContractsLiveData

    fun loadContracts() {
        viewModelScope.launch {
            _getContractsLiveData.postValue(useCase())
        }
    }
}
