package com.ronivaldoroner.repositories.providers.remote.commons

import com.ronivaldoroner.repositories.providers.remote.commons.ResultRemote.ErrorResponse.Generic

interface ResultCallback<T> {
    fun onSuccess(data: T)
    fun onError(error: Generic)
}