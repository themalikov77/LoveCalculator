package com.example.lovecalculator.data.repository

import androidx.lifecycle.LiveData
import com.example.lovecalculator.db.LoveDao
import com.example.lovecalculator.remote.LoveModel
import javax.inject.Inject

class RoomRepository @Inject constructor(private val appDao: LoveDao) {
    fun getAll(): LiveData<List<LoveModel>> {
        return appDao.getAllLove()
    }
    fun insert(loveModel: LoveModel){
        appDao.insert(loveModel)
    }
    fun update(loveModel: LoveModel){
        appDao.update(loveModel)
    }
}