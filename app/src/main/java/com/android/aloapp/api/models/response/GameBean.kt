package com.android.aloapp.api.models.response

import com.google.gson.annotations.SerializedName

data class GameBean(
    val id: Int,
    val title: String,
    val description: String,
    val rate: String,
    @SerializedName("players_count") val playerCount: Int,
    val genre: GenreBean,
    val image: String,
    val video: String
) {
    constructor() : this(0, "", "", "", 0, GenreBean(), "", "")
}