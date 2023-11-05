package com.example.simplifyinjections.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory

internal class DefaultViewModelFactory(private val viewModel: ViewModel) : Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModel as T
    }
}

internal inline fun <reified VM : ViewModel> VM.factoryViewModel(): Factory {
    return DefaultViewModelFactory(this)
}
