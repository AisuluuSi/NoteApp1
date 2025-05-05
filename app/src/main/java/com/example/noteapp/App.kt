package com.example.noteapp

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.noteapp.data.db.AppDataBase
import com.example.noteapp.utils.PreferenceHelper

class App: Application() {

    companion object{
        var appDataBase: AppDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()
        val shared = PreferenceHelper()
        shared.unit(this)
        getInstance()
    }

    private fun getInstance(): AppDataBase? {
        if (appDataBase == null){
            appDataBase = applicationContext?.let { context: Context ->
                Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    "note_database"
                ).fallbackToDestructiveMigration(false).allowMainThreadQueries().build()
            }
        }
        return appDataBase

    }
}