package com.android.aloapp.api

import kotlinx.coroutines.*

object RetrofitCallBack {
    fun <T> callApi(
        request: Deferred<T>,
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        GlobalScope.launch {
            try {
                val response = request.await()
                withContext(Dispatchers.Main) {
                    onSuccess(response)
                }
            } catch (e: Throwable) {
                withContext(Dispatchers.Main) {
                    onError(e)
                }
            }
        }
    }

}