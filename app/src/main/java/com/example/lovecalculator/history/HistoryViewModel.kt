package com.example.lovecalculator.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.data.repository.Repository
import com.example.lovecalculator.data.repository.RoomRepository

import com.example.lovecalculator.db.LoveDao
import com.example.lovecalculator.remote.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val repository: RoomRepository) : ViewModel() {
    fun getLiveHistory(): LiveData<List<LoveModel>> {
        return repository.getAll()
    }
    fun getInsert(loveModel: LoveModel) {
        return repository.insert(loveModel)
    }

}