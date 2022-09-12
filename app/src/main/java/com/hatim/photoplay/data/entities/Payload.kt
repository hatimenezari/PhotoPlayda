package com.hatim.photoplay.data.entities

import com.google.gson.annotations.SerializedName

data class Payload(
    val query: Query,
    val options: Options
)

data class Query(
    val upcoming: Boolean
)

data class Options(
    val sort: SortOptions,
    val populate: List<String>,
    val limit: Int
)

data class SortOptions(
    @SerializedName("flight_number") val flightNumber: String,
)