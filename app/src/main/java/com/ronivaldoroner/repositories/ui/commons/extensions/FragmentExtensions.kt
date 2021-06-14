package com.ronivaldoroner.repositories.ui.commons.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.*

inline fun <reified T> Fragment.observe(
    liveData: LiveData<T>,
    crossinline execution: (T) -> Unit
){
    liveData.observe(viewLifecycleOwner, Observer{execution(it)})
}
