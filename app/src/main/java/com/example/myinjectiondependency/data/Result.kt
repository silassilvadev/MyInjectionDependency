package com.example.myinjectiondependency.data

internal sealed class Result<out R> {
    data class Success<out S>(val value: S) : Result<S>()
    data class Error<S>(val error: Throwable) : Result<S>()
}
