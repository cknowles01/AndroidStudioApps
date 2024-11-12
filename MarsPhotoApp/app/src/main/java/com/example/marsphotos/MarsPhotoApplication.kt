package com.example.marsphotos

import android.app.Application
import com.example.marsphotos.data.AppContainer

import com.example.marsphotos.data.DefaultAppContainter


class MarsPhotoApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainter()
    }

}

