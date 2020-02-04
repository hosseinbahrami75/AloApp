package com.android.aloapp.api

import com.android.aloapp.api.models.response.GameBean
import kotlinx.coroutines.Deferred
import retrofit2.http.GET


interface ApiCall {

    //Get GamesList
    @GET("pnfbu")
    fun getGames(): Deferred<List<GameBean>>


    //Get GameDetails
    @GET("1bjyoa")
    fun getGameDetails(): Deferred<GameBean>
}
