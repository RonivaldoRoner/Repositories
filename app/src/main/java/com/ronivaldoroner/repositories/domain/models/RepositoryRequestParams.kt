package com.ronivaldoroner.repositories.domain.models

import java.io.Serializable

data class RepositoryRequestParams(
    val language: List<String> = listOf("Java"),
    val sort: String = "stars",
    val page: Int = 1
) : Serializable