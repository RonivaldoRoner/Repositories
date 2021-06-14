package com.ronivaldoroner.repositories.providers.remote.commons

import retrofit2.HttpException
import java.io.IOException

fun Throwable.mapRemoteErrors(): ResultRemote.ErrorResponse.Generic {
    return when (this) {
        is HttpException -> {
            when (code()) {
                else -> ResultRemote.ErrorResponse.Generic(this, code())
            }
        }
        is IOException -> {
            ResultRemote.ErrorResponse.Generic(this, -1)
        }
        else -> ResultRemote.ErrorResponse.Generic(this, -1)
    }
}