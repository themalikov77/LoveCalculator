package com.example.lovecalculator.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.lovecalculator.remote.LoveModel
import javax.inject.Inject
import javax.inject.Singleton

@Dao
interface LoveDao  {

    @Query
        ("SELECT*FROM lovemodel ORDER BY firsName,secondName DESC")
    fun getAllLove(): LiveData<List<LoveModel>>

    @Insert
    fun insert(model: LoveModel)



    @Update
    fun update(loveModel: LoveModel)
}
