package com.example.lovecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.lovecalculator.data.Pref
import com.example.lovecalculator.databinding.ActivityMainBinding
import com.example.lovecalculator.di.AppModule
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var pref: Pref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = Pref()
        val navController = findNavController(R.id.nav_host_fragment)
       //
        if (!pref.isBoardingShow()) {
            navController.navigate(R.id.onBoardingFragment)
        }
    }
}