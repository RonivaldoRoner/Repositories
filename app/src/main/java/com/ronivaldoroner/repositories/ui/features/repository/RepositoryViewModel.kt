package com.ronivaldoroner.repositories.ui.features.repository

import androidx.lifecycle.viewModelScope
import com.ronivaldoroner.repositories.domain.models.BaseModel
import com.ronivaldoroner.repositories.domain.models.RepositoryItemModel
import com.ronivaldoroner.repositories.domain.models.RepositoryModel
import com.ronivaldoroner.repositories.domain.models.RepositoryRequestParams
import com.ronivaldoroner.repositories.domain.providers.GitHubProvider
import com.ronivaldoroner.repositories.ui.base.BaseViewModel
import com.ronivaldoroner.repositories.ui.commons.model.UIState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

@ExperimentalCoroutinesApi
class RepositoryViewModel(
    private val remoteProvider: GitHubProvider
) : BaseViewModel() {

    private val _repositories = MutableStateFlow<List<RepositoryItemModel>>(listOf())
    val repositories: StateFlow<List<RepositoryItemModel>> = _repositories

    private val _screenState = MutableStateFlow<UIState<BaseModel>>(UIState.Loading)
    val screenState: StateFlow<UIState<BaseModel>> get() = _screenState

    init {
        screenState
            .onStart { loadData() }
            .onEach { handleState(it) }
            .launchIn(viewModelScope)
    }

    private fun loadData() {
        launchModel(data = _screenState) {
            remoteProvider.getRepositories(
                params = RepositoryRequestParams()
            )
        }
    }

    override fun <T> handleState(data: UIState<T>) {
        when (data) {
            is UIState.Success -> handleSuccess(data.result)
            is UIState.Failure -> handleError(data.code, data.message)
            else -> {
            }
        }
    }

    override fun <T> handleSuccess(data: T) {
        (data as RepositoryModel).let { repositoryModel ->
            repositoryModel.itemModels?.let { _repositories.value = it }
        }
    }

    override fun handleError(code: Int, message: String) {
        //Do anything if you need it
    }
}