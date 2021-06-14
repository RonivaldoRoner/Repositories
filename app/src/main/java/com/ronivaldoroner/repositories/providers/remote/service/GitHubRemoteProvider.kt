package com.ronivaldoroner.repositories.providers.remote.service

import com.ronivaldoroner.repositories.domain.models.RepositoryModel
import com.ronivaldoroner.repositories.domain.models.RepositoryRequestParams
import com.ronivaldoroner.repositories.domain.providers.GitHubProvider
import com.ronivaldoroner.repositories.providers.remote.api.GitHubApi
import com.ronivaldoroner.repositories.providers.remote.commons.ResultCallback
import com.ronivaldoroner.repositories.providers.remote.commons.ResultRemote
import com.ronivaldoroner.repositories.providers.remote.commons.mapRemoteErrors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GitHubRemoteProvider(private val gitHubApi: GitHubApi) : GitHubProvider {

    override suspend fun getRepositories(
        params: RepositoryRequestParams,
        callback: ResultCallback<RepositoryModel>
    ) = try {

        val result = gitHubApi.getRepositoriesByLanguage(
            language = params.language.joinToString(prefix = "language:", separator = "+language:"),
            sort = params.sort,
            page = params.page
        )

        callback.onSuccess(result)
    } catch (ex: Throwable) {
        callback.onError(ex.mapRemoteErrors())
    }
}