package com.example.lovecalculator

import android.app.Application
import androidx.room.Room
import com.example.lovecalculator.db.AppDatabase

import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application (){
    companion object{
        lateinit var appDataBase : AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        appDataBase = Room.databaseBuilder(applicationContext,AppDatabase::class.java,"name").allowMainThreadQueries().build()
    }
}