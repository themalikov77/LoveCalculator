package com.example.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository):ViewModel() {
   // private val repository = Repository()
    fun getLiveLoveModel(firstName:String,secondName:String):LiveData<LoveModel>{
        return repository.getLiveLove(firstName,secondName)
    }



}