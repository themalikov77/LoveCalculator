package com.example.lovecalculator.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
@Entity
data class LoveModel(
    @SerializedName("fname")
    var firsName:String,
    @SerializedName("sname")
    var secondName:String,
    var percentage:String,
    var result:String,
    @PrimaryKey(autoGenerate = true)
    val id:Int
    ) : Serializable
