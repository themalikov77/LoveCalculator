package com.example.lovecalculator

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.repository.Repository

class LoveViewModel:ViewModel() {
    private val repository = Repository()
    fun getLiveLoveModel(firstName:String,secondName:String):LiveData<LoveModel>{
        return repository.getLiveLove(firstName,secondName)
    }



}