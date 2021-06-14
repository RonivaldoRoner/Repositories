package com.ronivaldoroner.repositories.ui.commons.model

sealed class UIState {
    object Loading: UIState()
    object Success : UIState()
    object Failure: UIState()
}