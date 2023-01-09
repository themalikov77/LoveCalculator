package com.example.lovecalculator.di


import android.content.Context
import com.example.lovecalculator.App
import com.example.lovecalculator.data.local.Pref
import com.example.lovecalculator.db.AppDatabase
import com.example.lovecalculator.db.LoveDao
import com.example.lovecalculator.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule() {

    @Provides
    fun provideApp(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)

    }

    @Provides
    fun providePref(@ApplicationContext context: Context): Pref {
        return Pref(context)
    }
    @Provides
    fun provideRoom(@ApplicationContext context: Context) : AppDatabase{
        return App.appDataBase
    }
     @Provides
     fun getDao(appDatabase: AppDatabase): LoveDao {
         return appDatabase.getDao()

     }
}

