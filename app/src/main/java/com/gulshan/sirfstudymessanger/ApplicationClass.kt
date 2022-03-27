package com.gulshan.sirfstudymessanger

import android.app.Application

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()

        // initializing shared preferences for any future use
        SharedPref.init(this)
    }
}