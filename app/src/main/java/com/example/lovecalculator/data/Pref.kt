package com.example.lovecalculator.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Pref {
    private lateinit var pref: SharedPreferences

    fun addPref(context: Context) {
        pref = context.getSharedPreferences("pref_name", MODE_PRIVATE)
    }

    fun isBoardingShow(): Boolean {
        return pref.getBoolean(BOARDING_SHOW, false)
    }

    fun saveShowBoarding(isShow: Boolean) {
        pref.edit().putBoolean(BOARDING_SHOW, isShow).apply()
    }

    companion object {
        const val BOARDING_SHOW = "onBoardingShow"
    }
}