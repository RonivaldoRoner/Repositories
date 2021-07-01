package com.ronivaldoroner.repositories.ui.commons.model

sealed class UIState<out T> {
    object Loading: UIState<Nothing>()
    data class Success<out T>(val result: T) : UIState<T>()
    data class Failure(val code: Int = 0, val message: String): UIState<Nothing>()
}