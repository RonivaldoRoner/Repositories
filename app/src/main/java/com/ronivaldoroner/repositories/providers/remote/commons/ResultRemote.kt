package com.ronivaldoroner.repositories.providers.remote.commons

sealed class ResultRemote<out T> {
    data class Success<out T>(val response: T) : ResultRemote<T>()

    sealed class ErrorResponse(open val throwable: Throwable, open val codError: Int) :
        ResultRemote<Nothing>() {
        data class Generic(override val throwable: Throwable, override val codError: Int) :
            ErrorResponse(throwable, codError)
    }
}