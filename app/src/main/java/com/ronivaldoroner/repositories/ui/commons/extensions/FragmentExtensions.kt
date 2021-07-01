package com.ronivaldoroner.repositories.ui.commons.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach

inline fun <reified T> Fragment.observe(
    liveData: LiveData<T>,
    crossinline execution: (T) -> Unit
) {
    liveData.observe(viewLifecycleOwner, Observer { execution(it) })
}

inline fun <reified T> Fragment.observe(
    stateFlow: StateFlow<T>,
    crossinline execution: (T) -> Unit
) {
    stateFlow.onEach { execution(it) }
}
