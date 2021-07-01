package com.ronivaldoroner.repositories.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ronivaldoroner.repositories.domain.models.BaseModel
import com.ronivaldoroner.repositories.ui.commons.model.UIState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

@ExperimentalCoroutinesApi
abstract class BaseViewModel : ViewModel() {

    fun <T> launchModel(data: MutableStateFlow<UIState<BaseModel>>, function: suspend () -> Response<T>) {
        data.value = UIState.Loading
        viewModelScope.launch {
            try {
                val result = function.invoke()
                if (result.isSuccessful) {
                    data.value = UIState.Success(result.body()!! as BaseModel)
                } else {
                    data.value =
                        UIState.Failure(code = result.code(), message = result.message())
                }
            } catch (ex: Throwable) {
                data.value = UIState.Failure(message = ex.message?: "Erro Inesperado.")
            }
        }
    }

    abstract fun <T> handleState(data: UIState<T>)

    abstract fun <T> handleSuccess(data: T)

    abstract fun handleError(code: Int, message: String)
}