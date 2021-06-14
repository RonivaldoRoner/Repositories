package com.ronivaldoroner.repositories.ui.features.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ronivaldoroner.repositories.domain.models.RepositoryModel
import com.ronivaldoroner.repositories.domain.models.RepositoryRequestParams
import com.ronivaldoroner.repositories.domain.providers.GitHubProvider
import com.ronivaldoroner.repositories.providers.remote.commons.ResultCallback
import com.ronivaldoroner.repositories.providers.remote.commons.ResultRemote
import com.ronivaldoroner.repositories.ui.commons.model.UIState
import kotlinx.coroutines.launch

class RepositoryViewModel(
    private val remoteProvider: GitHubProvider
) : ViewModel(), ResultCallback<RepositoryModel> {

    private val _screenState = MutableLiveData<UIState>()
    val screenState: LiveData<UIState> get() = _screenState

    private val _screenData = MutableLiveData<RepositoryModel>()
    val screenData: LiveData<RepositoryModel> get() = _screenData

    init {
        _screenState.value = UIState.Loading
        viewModelScope.launch {
            remoteProvider.getRepositories(
                params =  RepositoryRequestParams(),
                this@RepositoryViewModel
            )
        }
    }

    override fun onSuccess(data: RepositoryModel) {
        _screenState.value = UIState.Success
        _screenData.value = data
    }

    override fun onError(error: ResultRemote.ErrorResponse.Generic) {
        _screenState.value = UIState.Failure
    }
}