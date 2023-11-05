package com.example.myinjectiondependency.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory

internal class MyInjectionViewModelFactory(private val viewModel: ViewModel) : Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModel as T
    }
}

internal inline fun <reified VM : ViewModel> VM.factoryViewModel(): Factory {
    return MyInjectionViewModelFactory(this)
}
