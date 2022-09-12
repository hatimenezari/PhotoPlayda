package com.hatim.photoplay.data.entities

import com.google.gson.annotations.SerializedName

data class Document(
    val success: Boolean,
    @SerializedName("flight_number") val flightNumber: Int,
    val name: String,
    @SerializedName("date_unix") val dateUnix: Int,
    val id: String,
    val links: Links
)

data class Links(
    val webcast: String,
    val wikipedia: String,
    val patch: Patch
)

data class Patch(
    val small: String,
    val large: String,
)

data class Documents(
    val docs: List<Document>
)