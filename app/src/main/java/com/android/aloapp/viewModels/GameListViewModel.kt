package com.android.aloapp.viewModels

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.aloapp.api.RetrofitCallBack
import com.android.aloapp.api.RetrofitClient
import com.android.aloapp.api.models.response.GameBean
import com.android.aloapp.utils.CheckNetwork


class GameListViewModel : ViewModel() {
    private var gamesData: MutableLiveData<List<GameBean>> = MutableLiveData()

    fun getLiveGamesData(context: Context): MutableLiveData<List<GameBean>> {
        if (CheckNetwork.isNetworkAvailable(context)) {
            RetrofitCallBack.callApi(RetrofitClient.getService().getGames(), {
                gamesData.value = it
            }, {
                Log.v("gamesListErr", it.message.toString())
            })

        } else {
            //TODO Fetch from room dataBase
            //Create Repository and fetchData here
        }
        return gamesData
    }


}