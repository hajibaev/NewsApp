package com.example.domain

sealed class RequestState<T> {
    class Loading<T> : RequestState<T>()
    data class Error<T>(val exception: Throwable) : RequestState<T>()
    data class Success<T>(val value: T) : RequestState<T>()
}

