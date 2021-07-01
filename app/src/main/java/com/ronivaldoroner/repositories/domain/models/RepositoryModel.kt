package com.ronivaldoroner.repositories.domain.models

import com.google.gson.annotations.SerializedName

data class RepositoryModel(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean?,
    @SerializedName("items")
    val itemModels: List<RepositoryItemModel>?,
    @SerializedName("total_count")
    val totalCount: Int?
): BaseModel