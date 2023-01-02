package com.example.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculator.databinding.FragmentResultLoveBinding

class
ResultLoveFragment : Fragment() {
    private lateinit var binding: FragmentResultLoveBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultLoveBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()

    }

    private fun initUi() {

       binding.resultMe.text = arguments?.getString("sname")
        binding.resultYou.text = arguments?.getString("fname")
       binding.tvResult.text = arguments?.getString("percentage")
    }
}