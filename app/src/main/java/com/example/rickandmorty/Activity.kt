package com.example.rickandmorty

import android.app.Application
import com.example.rickandmorty.di.modules.dataModule
import com.example.rickandmorty.di.modules.domainModule
import com.example.rickandmorty.di.modules.presentationModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Activity : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(
                if(BuildConfig.DEBUG){
                    Level.INFO
                } else {
                    Level.NONE
                }
            )
            androidContext(this@Activity)
            modules(
                dataModule,
                presentationModule,
                domainModule,
            )
        }
    }
}