package com.android.aloapp.api.models.response

import com.google.gson.annotations.SerializedName

data class GenreBean(
    @SerializedName("id")
    val genreId: Int,
    @SerializedName("name")
    val genreName: String,
    @SerializedName("image")
    val genreImage: String
) {
    constructor() : this(0, "", "")
}