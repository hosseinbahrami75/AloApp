package com.android.aloapp

import android.app.Application

class App: Application() {


    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        @get:Synchronized
        lateinit var application: App
    }

}