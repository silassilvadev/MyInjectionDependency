package com.example.myinjectiondependency.ui.main

internal sealed class MainState {
    data class Success(val contractId: String) : MainState()
    data class Failure(val message: String) : MainState()
}
