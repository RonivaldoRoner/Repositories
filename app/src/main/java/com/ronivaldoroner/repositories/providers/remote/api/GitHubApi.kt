package com.ronivaldoroner.repositories.providers.remote.api

import com.ronivaldoroner.repositories.domain.models.RepositoryModel
import com.ronivaldoroner.repositories.providers.remote.commons.ResultRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {

    @GET("search/repositories")
    suspend fun getRepositoriesByLanguage(
        @Query("q", encoded = true) language: String,
        @Query("sort") sort: String,
        @Query("page") page: Int
    ): RepositoryModel

}