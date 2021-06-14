package com.ronivaldoroner.repositories.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RepositoryModel(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean?,
    @SerializedName("items")
    val itemModels: List<RepositoryItemModel>?,
    @SerializedName("total_count")
    val totalCount: Int?
): Serializable