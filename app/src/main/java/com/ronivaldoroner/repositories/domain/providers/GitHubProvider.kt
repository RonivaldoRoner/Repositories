package com.ronivaldoroner.repositories.domain.providers

import com.ronivaldoroner.repositories.domain.models.RepositoryModel
import com.ronivaldoroner.repositories.domain.models.RepositoryRequestParams
import com.ronivaldoroner.repositories.providers.remote.commons.ResultCallback

interface GitHubProvider {

    suspend fun getRepositories(
        params: RepositoryRequestParams,
        callback: ResultCallback<RepositoryModel>
    )

}