package com.example.simplifyinjections.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplifyinjections.data.Result
import com.example.simplifyinjections.domain.usecase.MainUseCase
import kotlinx.coroutines.launch

internal class MainViewModel(private val useCase: MainUseCase) : ViewModel() {

    private val _getContractsLiveData = MutableLiveData<MainState>()
    val getContractsLiveData: LiveData<MainState> = _getContractsLiveData

    fun loadContracts() {
        viewModelScope.launch {
            val response = useCase()
            val state = if (response is Result.Success) {
                MainState.Success(response.value.contractId)
            } else {
                MainState.Failure((response as? Result.Error)?.error?.message.orEmpty())
            }
            _getContractsLiveData.postValue(state)
        }
    }
}
